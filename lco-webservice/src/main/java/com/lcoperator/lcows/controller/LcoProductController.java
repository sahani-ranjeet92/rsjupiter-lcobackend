package com.lcoperator.lcows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcows.common.LcoResponseInfo;
import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.exception.LcoProductException;
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

	@PostMapping("/addProduct")
	public ResponseEntity<LcoResponseInfo> addProduct(ProductDto prod) {
		try {
			long id = manager.addProduct(prod);
			prod.setCatentryId(id);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), prod, HttpStatus.OK);
		} catch (LcoProductException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/updateProduct")
	public ResponseEntity<LcoResponseInfo> updateProduct(ProductDto prod) {
		try {
			long id = manager.updateProduct(prod);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), prod, HttpStatus.OK);
		} catch (LcoProductException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/removeProduct/{id}")
	public ResponseEntity<LcoResponseInfo> removeProduct(@PathVariable("id") long catentryId) {
		try {
			long id = manager.removeProduct(catentryId);
			if (id > 0)
				return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), catentryId, HttpStatus.OK);
			else
				return getSuccessResponseInfo("Invalid input data", catentryId, HttpStatus.BAD_REQUEST);
		} catch (LcoProductException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
