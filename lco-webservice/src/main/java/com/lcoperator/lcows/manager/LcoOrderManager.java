package com.lcoperator.lcows.manager;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
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
		} catch (IllegalArgumentException ex) {
			throw new LcoOrderException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		long orderid = orderService.addOrderItem(request);
		return orderService.getOrderDetail(orderid);

	}

}
