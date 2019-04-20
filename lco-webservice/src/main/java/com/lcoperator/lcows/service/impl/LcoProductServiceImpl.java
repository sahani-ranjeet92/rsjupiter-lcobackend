package com.lcoperator.lcows.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Offerprice;
import com.lcoperator.lcodb.repository.CatentryRepository;
import com.lcoperator.lcows.common.ProductDto;
import com.lcoperator.lcows.service.LcoProductService;

/**
 * @author ranjeet
 *
 */
@Service
public class LcoProductServiceImpl implements LcoProductService {

	@Autowired
	private CatentryRepository cRepository;

	@Override
	public List<ProductDto> getProductList() {
		List<ProductDto> productList = new ArrayList<>();
		cRepository.findAll().forEach(catentry -> {
			ProductDto product = new ProductDto();
			product.setCatentryId(catentry.getCatentryId());
			product.setChname(catentry.getChname());
			product.setChnumber(catentry.getChnumber());
			product.setUrl(catentry.getUrl());
			Optional<Offerprice> offerPrice = catentry.getOfferprices().stream()
					.filter(price -> price.getPricetype().equals("list")).findFirst();
			if (offerPrice.isPresent())
				product.setPrice(offerPrice.get().getPrice().doubleValue());
			productList.add(product);
		});
		return productList;
	}

}
