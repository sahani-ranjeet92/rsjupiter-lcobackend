
package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Cattogrp;
import com.lcoperator.lcodb.model.CattogrpId;

@Repository
public interface CattogrpRepository extends CrudRepository<Cattogrp, CattogrpId> {

}
