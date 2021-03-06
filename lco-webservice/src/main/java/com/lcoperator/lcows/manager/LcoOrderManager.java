package com.lcoperator.lcows.manager;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.common.RemoveOrderItemReqDto;
import com.lcoperator.lcows.exception.LcoOrderException;
import com.lcoperator.lcows.service.LcoOrderService;

/**
 * @author ranjeet
 *
 */
@Component
public class LcoOrderManager {

	@Autowired
	private LcoOrderService orderService;

	public OrderResponseDto addOrderItem(OrderReqDto request) throws LcoOrderException {
		try {
			Validate.notNull(request, "Invalid input request");
			Validate.notNull(request.getUserId(), "UserId cannot be null");
			Validate.isTrue(!request.getPackageId().isEmpty() || !request.getProductIds().isEmpty(),
					"Either productid or packageid must be present");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		long orderid = orderService.addOrderItem(request);
		return orderService.getOrderDetail(orderid);

	}

	public OrderResponseDto removeOrderItem(RemoveOrderItemReqDto request) throws LcoOrderException {
		try {
			Validate.notNull(request, "Invalid input request");
			Validate.notNull(request.getUserId(), "UserId cannot be null");
			Validate.notNull(request.getOrderId(), "OrdrerId cannot be null");
			Validate.notNull(request.getOrderItemId(), "OrderItemId cannot be null");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		long orderid = orderService.removeOrderItem(request);
		return orderService.getOrderDetail(orderid);
	}

	public OrderResponseDto getOrderDetail(Long orderId) throws LcoOrderException {
		try {
			Validate.notNull(orderId, "orderId cannot be null");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return orderService.getOrderDetail(orderId);
	}

	public OrderResponseDto getOrderByUserId(Long userId) throws LcoOrderException {
		try {
			Validate.notNull(userId, "userId cannot be null");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return orderService.getOrderByUserId(userId);
	}

	public void checkout(Long orderId, Long userId) throws LcoOrderException {
		try {
			Validate.notNull(orderId, "orderId cannot be null");
			Validate.notNull(userId, "UserId cannot be null");
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		orderService.orderCheckout(orderId, userId);

	}

	public List<OrderResponseDto> getOrderList() {
		return orderService.getOrderList();
	}

}
