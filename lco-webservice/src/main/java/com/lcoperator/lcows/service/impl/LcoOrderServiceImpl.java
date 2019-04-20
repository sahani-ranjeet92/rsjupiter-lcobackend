package com.lcoperator.lcows.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Catentry;
import com.lcoperator.lcodb.model.Offerprice;
import com.lcoperator.lcodb.model.Orderitems;
import com.lcoperator.lcodb.model.Orders;
import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcodb.repository.CatentryRepository;
import com.lcoperator.lcodb.repository.OfferpriceRepository;
import com.lcoperator.lcodb.repository.OrderitemsRepository;
import com.lcoperator.lcodb.repository.OrdersRepository;
import com.lcoperator.lcodb.repository.UserRepository;
import com.lcoperator.lcows.common.OrderItemDto;
import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.common.OrderStatusEnum;
import com.lcoperator.lcows.common.ProductDto;
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
		BigDecimal totalPrice = BigDecimal.ZERO;
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
			totalPrice.add(price);
		}
		orders.setTotalproduct(totalPrice);
		ordersRepository.save(orders);
		return orders.getOrdersId();
	}

	@Override
	public OrderResponseDto getOrderDetail(long orderid) throws LcoOrderException {
		Optional<Orders> orders = ordersRepository.findById(orderid);
		if (!orders.isPresent()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order does not exist!");
		}
		return mapOrdersToOrderResponseDto(orders.get());
	}

	@Override
	public OrderResponseDto getOrderByUserId(Long userId) throws LcoOrderException {
		Orders orders = ordersRepository.findOrder(userId, OrderStatusEnum.NEW.getStatusName());
		if (orders == null) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order does not exist!");
		}
		return mapOrdersToOrderResponseDto(orders);

	}

	private OrderResponseDto mapOrdersToOrderResponseDto(Orders orders2) {
		OrderResponseDto response = new OrderResponseDto();
		response.setOrderId(orders2.getOrdersId());
		response.setUserId(orders2.getUser().getUserId());
		response.setTotalPrice(orders2.getTotalproduct().doubleValue());
		response.setLastUpdate(orders2.getLastupdate().toString());
		response.setCreationDate(orders2.getTimeplaced().toString());
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
		return response;
	}

}
