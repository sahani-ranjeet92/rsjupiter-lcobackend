package com.lcoperator.lcows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcows.common.LcoResponseInfo;
import com.lcoperator.lcows.common.OrderReqDto;
import com.lcoperator.lcows.common.OrderResponseDto;
import com.lcoperator.lcows.exception.LcoOrderException;
import com.lcoperator.lcows.manager.LcoOrderManager;

/**
 * @author ranjeet
 *
 */
@RestController
@RequestMapping("/order-service")
public class LcoOrderController extends LcoBaseController {

	@Autowired
	private LcoOrderManager manager;

	@PostMapping(value = "/addOrderItem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> addOrderItem(@RequestBody OrderReqDto request) {
		try {
			OrderResponseDto data = manager.addOrderItem(request);
			return getSuccessResponseInfo("Item Added Successfully", data, HttpStatus.OK);
		} catch (LcoOrderException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getOrder/{type}/{id:[\\d]+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> getOrderDetail(@PathVariable("type") String type,
			@PathVariable("id") Long id) {
		try {
			OrderResponseDto data = null;
			if (type.equalsIgnoreCase("orderId"))
				data = manager.getOrderDetail(id);
			else
				data = manager.getOrderByUserId(id);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (LcoOrderException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> checkout(@RequestParam Long orderId, @RequestParam Long userId) {
		try {
			manager.checkout(orderId, userId);
			return getSuccessResponseInfo("Ordered checkout Successfully", null, HttpStatus.OK);
		} catch (LcoOrderException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
