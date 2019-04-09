package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Checkout;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, Long> {

}
