package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Catentry;

@Repository
public interface CatentryRepository extends CrudRepository<Catentry, Long> {

}
