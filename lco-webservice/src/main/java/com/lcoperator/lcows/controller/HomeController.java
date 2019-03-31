package com.lcoperator.lcows.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcodb.model.Catalog;
import com.lcoperator.lcodb.repository.CatalogRepository;

@RestController
public class HomeController {

	@Autowired
	private CatalogRepository catalogRepository;

	@GetMapping("/lcows/api")
	public String getHome() {
		return "Welcome to lco web application";
	}

	@GetMapping("/lcows/api/getCatalogList")
	public String getCatalogList() {
		Iterable<Catalog> findAll = catalogRepository.findAll();
		List<Catalog> list = new ArrayList<Catalog>();
		for (Catalog element : findAll) {
			list.add(element);
		}
		return list.stream().map(c -> c.getCatalogId()).collect(Collectors.toList()).toString();
	}
}
