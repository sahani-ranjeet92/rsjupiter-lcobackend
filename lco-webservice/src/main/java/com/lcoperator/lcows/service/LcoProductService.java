package com.lcoperator.lcows.service;

import java.util.List;

import com.lcoperator.lcows.common.ProductDto;

/**
 * @author ranjeet
 *
 */
public interface LcoProductService {

	List<ProductDto> getProductList();

	long addProduct(ProductDto prod);

	long updateProduct(ProductDto prod);

	long removeProduct(long catentryId);

	ProductDto getProduct(long catentryId);

}
