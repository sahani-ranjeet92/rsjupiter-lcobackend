package com.lcoperator.lcows.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Catentry;
import com.lcoperator.lcodb.model.Orders;
import com.lcoperator.lcodb.repository.CatentryRepository;
import com.lcoperator.lcodb.repository.OrdersRepository;
import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.exception.LcoOrderException;
import com.lcoperator.lcows.service.LcoOrderService;

@Service
public class LcoOrderServiceImpl implements LcoOrderService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private CatentryRepository catentryRepository;

	@Override
	public long addOrderItem(OrderReqDto request) {
		// TODO Auto-generated method stub
		return 0;
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
			ProductDto dto = new ProductDto();
			dto.setCatentryId(oi.getProductId());
			Optional<Catentry> channel = catentryRepository.findById(oi.getProductId());
			if (channel.isPresent()) {
				dto.setChname(channel.get().getChname());
				dto.setChnumber(channel.get().getChnumber());
			}
			return dto;
		}).collect(Collectors.toList()));
		return response;
	}

}
