package com.lcoperator.lcows.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Catentry;
import com.lcoperator.lcodb.model.Orderitems;
import com.lcoperator.lcodb.model.Orders;
import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcodb.repository.CatentryRepository;
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

	@Override
	@Transactional
	public long addOrderItem(OrderReqDto request) throws LcoOrderException {
		Optional<User> user = userRepository.findById(request.getUserId());
		if (!user.isPresent()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "user not found");
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
		Orderitems oi = new Orderitems(orders, user.get(), request.getProductIds().get(0), BigDecimal.ZERO,
				OrderStatusEnum.NEW.getStatusName(), new Date(), new Date(), -1, BigDecimal.ZERO, BigDecimal.ZERO);
		orders.getOrderitemses().add(oi);
		ordersRepository.save(orders);
		return orders.getOrdersId();
	}

	@Override
	public OrderResponseDto getOrderDetail(long orderid) throws LcoOrderException {
		Optional<Orders> orders = ordersRepository.findById(orderid);
		if (!orders.isPresent()) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, "order does not exist!");
		}
		OrderResponseDto response = new OrderResponseDto();
		Orders orders2 = orders.get();
		response.setOrderId(orders2.getOrdersId());
		response.setUserId(orders2.getUser().getUserId());
		response.setChannels(orders2.getOrderitemses().stream().map(oi -> {
			OrderItemDto oiDto = new OrderItemDto();
			oiDto.setLastcreate(oi.getLastcreate());
			oiDto.setLastupdate(oi.getLastupdate());
			oiDto.setProductprice(oi.getProductprice().doubleValue());
			oiDto.setStatus(oi.getStatus());
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
