package com.lcoperator.lcows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@PostMapping(name = "/addOrderItem", consumes = MediaType.APPLICATION_JSON_VALUE)
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

}
