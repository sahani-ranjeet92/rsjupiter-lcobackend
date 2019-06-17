package com.lcoperator.lcows.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Catentry;
import com.lcoperator.lcodb.model.Checkout;
import com.lcoperator.lcodb.model.Offerprice;
import com.lcoperator.lcodb.model.Orderitems;
import com.lcoperator.lcodb.model.Orders;
import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcodb.repository.CatentryRepository;
import com.lcoperator.lcodb.repository.CheckoutRepository;
import com.lcoperator.lcodb.repository.OfferpriceRepository;
import com.lcoperator.lcodb.repository.OrderitemsRepository;
import com.lcoperator.lcodb.repository.OrdersRepository;
import com.lcoperator.lcodb.repository.UserRepository;
import com.lcoperator.lcows.common.OrderItemDto;
import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.common.OrderStatusEnum;
import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.common.RemoveOrderItemReqDto;
import com.lcoperator.lcows.exception.LcoOrderException;
import com.lcoperator.lcows.service.LcoOrderService;

@Service
public class LcoOrderServiceImpl implements LcoOrderService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private CatentryRepository catentryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OfferpriceRepository offerpriceRepository;

	@Autowired
	private OrderitemsRepository orderitemsRepository;

	@Autowired
	private CheckoutRepository checkoutRepository;

	@Override
	@Transactional
	public long addOrderItem(OrderReqDto request) throws LcoOrderException {
		Optional<User> user = userRepository.findById(request.getUserId());
		if (!user.isPresent()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "user not found");
		}
		List<Catentry> channels = catentryRepository.findAllChannels(request.getProductIds());
		if (channels.isEmpty() || channels.size() < request.getProductIds().size()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "Invalid channel list");
		}
		Orders orders = ordersRepository.findOrder(request.getUserId(), OrderStatusEnum.NEW.getStatusName());
		if (orders == null) {// create new order
			orders = new Orders();
			orders.setUser(user.get());
			orders.setTimeplaced(new Date());
			orders.setStatus(OrderStatusEnum.NEW.getStatusName());
			orders.setTotaladjustment(BigDecimal.ZERO);
			orders.setTotalproduct(BigDecimal.ZERO);
			orders.setTotaltax(BigDecimal.ZERO);
		}
		// add order item
		BigDecimal totalPrice = orders.getTotalproduct();
		List<Long> existingProdIds = orders.getOrderitemses().stream().map(Orderitems::getProductId)
				.collect(Collectors.toList());
		for (Catentry channel : channels) {

			// check item is already exist by prodId and new
			if (existingProdIds.contains(channel.getCatentryId()))
				throw new LcoOrderException(HttpStatus.BAD_REQUEST,
						"Item is already exist in cart :" + channel.getChname());

			List<Offerprice> offerPrice = channel.getOfferprices().stream()
					.filter(ch -> ch.getPricetype().equals("list")).collect(Collectors.toList());
			// TODO: test the logic
			offerPrice.sort((op1, op2) -> (int) (op2.getPrecedence() - op1.getPrecedence()));

			BigDecimal price = BigDecimal.ZERO;
			long offerId = 0;
			if (!offerPrice.isEmpty()) {
				price = offerPrice.get(0).getPrice();
				offerId = offerPrice.get(0).getOfferId();
			}

			Orderitems oi = new Orderitems(orders, user.get(), channel.getCatentryId(), price,
					OrderStatusEnum.NEW.getStatusName(), new Date(), new Date(), offerId, BigDecimal.ZERO,
					BigDecimal.ZERO);
			orders.getOrderitemses().add(oi);
			// add price
			totalPrice = totalPrice.add(price);
		}
		orders.setTotalproduct(totalPrice);
		ordersRepository.save(orders);
		return orders.getOrdersId();
	}

	@Override
	@Transactional
	public long removeOrderItem(RemoveOrderItemReqDto request) throws LcoOrderException {

		Orders orders = ordersRepository.findOrder(request.getOrderId(), request.getUserId(),
				OrderStatusEnum.NEW.getStatusName());
		if (orders == null) {// create new order
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order not found");
		}
		// remove order item
		Set<Orderitems> orderitemses = new HashSet<>(orders.getOrderitemses());
		double totalProductPrice = orderitemses.stream().map(oi -> {
			if (oi.getOrderitemsId().longValue() == request.getOrderItemId()) {
				orders.getOrderitemses().remove(oi);
				orderitemsRepository.delete(oi);
				return BigDecimal.ZERO;
			} else {
				return oi.getProductprice();
			}

		}).collect(Collectors.summingDouble((BigDecimal::doubleValue)));
		// double totalProductPrice =
		// orders.getOrderitemses().stream().map(Orderitems::getProductprice)
		// .collect(Collectors.summingDouble((BigDecimal::doubleValue)));
		orders.setTotalproduct(new BigDecimal(totalProductPrice));
		ordersRepository.save(orders);
		return orders.getOrdersId();
	}

	@Override
	public OrderResponseDto getOrderDetail(long orderid) throws LcoOrderException {
		Optional<Orders> ordersOpt = ordersRepository.findById(orderid);
		if (!ordersOpt.isPresent()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order does not exist!");
		}
		Orders orders = ordersOpt.get();
		OrderResponseDto orderResponse = mapOrdersToOrderResponseDto(orders);
		setChannelList(orders, orderResponse);
		return orderResponse;
	}

	@Override
	public OrderResponseDto getOrderByUserId(Long userId) throws LcoOrderException {
		Orders orders = ordersRepository.findOrder(userId, OrderStatusEnum.NEW.getStatusName());
		if (orders == null) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order does not exist!");
		}
		OrderResponseDto orderResponse = mapOrdersToOrderResponseDto(orders);
		setChannelList(orders, orderResponse);
		return orderResponse;

	}

	@Override
	@Transactional
	public void orderCheckout(Long orderId, Long userId) throws LcoOrderException {
		Orders orders = ordersRepository.findOrder(orderId, userId, OrderStatusEnum.NEW.getStatusName());
		try {
			Validate.notNull(orders, "order does not exist!");
			Validate.notEmpty(orders.getOrderitemses(), "order is empty!");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		// update order status to completed
		orders.setStatus(OrderStatusEnum.COMPLETED.getStatusName());
		Date currTime = new Date();
		orders.setLastupdate(currTime);
		orders.getOrderitemses().forEach(oi -> {
			oi.setStatus(OrderStatusEnum.COMPLETED.getStatusName());
		});
		ordersRepository.save(orders);

		Checkout checkout = new Checkout();
		checkout.setLastupdate(currTime);
		checkout.setTimeplaced(currTime);
		checkout.setOrdersId(orders.getOrdersId());
		checkout.setStatus("Deactive");
		checkout.setUserId(userId);

		checkoutRepository.save(checkout);

	}

	@Override
	public List<OrderResponseDto> getOrderList() {
		List<OrderResponseDto> list = new ArrayList<>();
		ordersRepository.findAll().forEach(orders -> {
			OrderResponseDto orderResponse = mapOrdersToOrderResponseDto(orders);
			orderResponse.setQuantity(orderitemsRepository.getItemCountByOrderId(orders.getOrdersId()));
			list.add(orderResponse);
		});
		return list;
	}

	private OrderResponseDto mapOrdersToOrderResponseDto(Orders orders2) {
		OrderResponseDto response = new OrderResponseDto();
		response.setOrderId(orders2.getOrdersId());
		response.setUserId(orders2.getUser().getUserId());
		response.setTotalPrice(orders2.getTotalproduct().doubleValue());
		response.setTotalTax(orders2.getTotaltax().doubleValue());
		response.setLastUpdate(orders2.getLastupdate().toString());
		response.setCreationDate(orders2.getTimeplaced().toString());
		response.setOrderStatus(orders2.getStatus());
		return response;
	}

	private void setChannelList(Orders orders2, OrderResponseDto response) {
		response.setChannels(orders2.getOrderitemses().stream().map(oi -> {
			OrderItemDto oiDto = new OrderItemDto();
			oiDto.setOrderitemsId(oi.getOrderitemsId());
			oiDto.setLastcreate(oi.getLastcreate());
			oiDto.setLastupdate(oi.getLastupdate());
			oiDto.setProductprice(oi.getProductprice().doubleValue());
			oiDto.setStatus(oi.getStatus());
			oiDto.setOfferId(oi.getOfferId());
			ProductDto dto = new ProductDto();
			dto.setCatentryId(oi.getProductId());
			Optional<Catentry> channel = catentryRepository.findById(oi.getProductId());
			if (channel.isPresent()) {
				dto.setChname(channel.get().getChname());
				dto.setChnumber(channel.get().getChnumber());
			}
			oiDto.setProduct(dto);
			return oiDto;
		}).collect(Collectors.toList()));
	}

}
