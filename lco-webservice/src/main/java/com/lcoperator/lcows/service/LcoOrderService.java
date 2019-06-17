package com.lcoperator.lcows.service;

import java.util.List;

import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.common.RemoveOrderItemReqDto;
import com.lcoperator.lcows.exception.LcoOrderException;

/**
 * @author ranjeet
 *
 */
public interface LcoOrderService {

	long addOrderItem(OrderReqDto request) throws LcoOrderException;

	long removeOrderItem(RemoveOrderItemReqDto request) throws LcoOrderException;
	
	OrderResponseDto getOrderDetail(long orderid) throws LcoOrderException;

	OrderResponseDto getOrderByUserId(Long userId) throws LcoOrderException;

	void orderCheckout(Long orderId, Long userId) throws LcoOrderException;
	
	List<OrderResponseDto> getOrderList();

	

}
