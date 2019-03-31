package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Catgpenrel;
import com.lcoperator.lcodb.model.CatgpenrelId;

@Repository
public interface CatgpenrelRepository extends CrudRepository<Catgpenrel, CatgpenrelId> {
}
