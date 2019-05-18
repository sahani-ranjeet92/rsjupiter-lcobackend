package com.lcoperator.lcows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcows.common.LcoResponseInfo;
import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.manager.LcoProductManager;

/**
 * @author ranjeet
 *
 */
@RestController
@RequestMapping("/product")
public class LcoProductController extends LcoBaseController {

	@Autowired
	private LcoProductManager manager;

	@GetMapping("/getProductList")
	public ResponseEntity<LcoResponseInfo> getProductList() {
		try {
			List<ProductDto> data = manager.getProductList();
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
