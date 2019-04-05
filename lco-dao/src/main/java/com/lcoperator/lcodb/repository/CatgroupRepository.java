package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Catgroup;

@Repository
public interface CatgroupRepository extends CrudRepository<Catgroup, Long> {

}
