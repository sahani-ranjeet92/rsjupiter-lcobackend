package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

}
