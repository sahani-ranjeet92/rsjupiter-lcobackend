package com.lcoperator.lcows.manager;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.exception.LcoProductException;
import com.lcoperator.lcows.service.LcoProductService;

/**
 * @author ranjeet
 *
 */
@Component
public class LcoProductManager {

	@Autowired
	private LcoProductService productService;

	public List<ProductDto> getProductList() {
		return productService.getProductList();
	}

	public long addProduct(ProductDto prod) throws LcoProductException {
		try {
			Validate.notNull(prod);
			Validate.notEmpty(prod.getChname());
			Validate.notEmpty(prod.getChnumber());
			Validate.notNaN(prod.getPrice());
			Validate.notNull(prod.getChannelImage());
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoProductException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return productService.addProduct(prod);
	}

	public long updateProduct(ProductDto prod) throws LcoProductException {
		try {
			Validate.notNull(prod);
			Validate.notNull(prod.getCatentryId());
			Validate.notEmpty(prod.getChname());
			Validate.notEmpty(prod.getChnumber());
			Validate.notNaN(prod.getPrice());
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoProductException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return productService.updateProduct(prod);
	}

	public long removeProduct(long catentryId) throws LcoProductException {
		try {
			Validate.notNull(catentryId);
		} catch (NullPointerException | IllegalArgumentException ex) {
			throw new LcoProductException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return productService.removeProduct(catentryId);
	}

}
