package com.lcoperator.lcows.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcoperator.lcows.common.ProductDto;
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

}
