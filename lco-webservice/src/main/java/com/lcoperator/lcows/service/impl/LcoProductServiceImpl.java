package com.lcoperator.lcows.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.Catentry;
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
			if (catentry.getMarkfordelete() == 0) {
				ProductDto product = mapCatentryToProductDto(catentry);
				productList.add(product);
			}
		});
		return productList;
	}

	private ProductDto mapCatentryToProductDto(Catentry catentry) {
		ProductDto product = new ProductDto();
		product.setCatentryId(catentry.getCatentryId());
		product.setChname(catentry.getChname());
		product.setChnumber(catentry.getChnumber());
		product.setUrl(catentry.getUrl());
		Optional<Offerprice> offerPrice = catentry.getOfferprices().stream()
				.filter(price -> price.getPricetype().equals("list")).findFirst();
		if (offerPrice.isPresent())
			product.setPrice(offerPrice.get().getPrice().doubleValue());
		return product;
	}

	@Override
	public long addProduct(ProductDto prod) {
		Date lastupdate = new Date();
		Catentry catentry = new Catentry(prod.getChnumber(), prod.getChname(), 0, lastupdate, lastupdate, lastupdate,
				lastupdate, lastupdate);
		// save price
		Offerprice offerprice = new Offerprice(catentry, lastupdate, lastupdate, 1L, 1, lastupdate,
				new BigDecimal(prod.getPrice()));
		offerprice.setPricetype("list");
		catentry.getOfferprices().add(offerprice);
		cRepository.save(catentry);

		// save file
		String pathname = "D:/temp/product_" + catentry.getCatentryId() + "_" + prod.getChnumber() + ".jpeg";
		File file = new File(pathname);
		try (FileOutputStream outputStream = new FileOutputStream(file);) {
			outputStream.write(prod.getChannelImage().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		catentry.setUrl(pathname);

		cRepository.save(catentry);
		return catentry.getCatentryId();
	}

	@Override
	public long updateProduct(ProductDto prod) {
		Optional<Catentry> findById = cRepository.findById(prod.getCatentryId());
		if (findById.isPresent()) {
			Catentry catentry = findById.get();
			catentry.setLastupdate(new Date());
			catentry.setChname(prod.getChname());
			catentry.setChnumber(prod.getChnumber());
			// update price
			Optional<Offerprice> offerPrice = catentry.getOfferprices().stream()
					.filter(price -> price.getPricetype().equals("list")).findFirst();
			if (offerPrice.isPresent())
				offerPrice.get().setPrice(new BigDecimal(prod.getPrice()));
			cRepository.save(catentry);
			return 1;
		}
		return 0;
	}

	@Override
	public long removeProduct(long catentryId) {
		Optional<Catentry> findById = cRepository.findById(catentryId);
		if (findById.isPresent()) {
			Catentry catentry = findById.get();
			catentry.setMarkfordelete(1);
			cRepository.save(catentry);
			return 1;
		}
		return 0;
	}

	@Override
	public ProductDto getProduct(long catentryId) {
		Optional<Catentry> catentry = cRepository.findById(catentryId);
		if (catentry.isPresent())
			return mapCatentryToProductDto(catentry.get());
		else
			return null;
	}

}
