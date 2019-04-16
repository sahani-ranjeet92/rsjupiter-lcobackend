package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Orderitems;

@Repository
public interface OrderitemsRepository extends CrudRepository<Orderitems, Long> {

}
