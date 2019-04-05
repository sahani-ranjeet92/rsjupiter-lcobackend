package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Catalog;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long> {

}
