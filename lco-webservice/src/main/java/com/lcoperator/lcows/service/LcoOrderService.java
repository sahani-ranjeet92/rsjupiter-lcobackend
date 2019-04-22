package com.lcoperator.lcows.service;

import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.exception.LcoOrderException;

/**
 * @author ranjeet
 *
 */
public interface LcoOrderService {

	long addOrderItem(OrderReqDto request) throws LcoOrderException;

	OrderResponseDto getOrderDetail(long orderid) throws LcoOrderException;

	OrderResponseDto getOrderByUserId(Long userId) throws LcoOrderException;

	void orderCheckout(Long orderId, Long userId) throws LcoOrderException;

}
