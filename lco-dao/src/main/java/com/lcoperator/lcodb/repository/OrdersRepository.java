
package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Suborders;

@Repository
public interface OrdersRepository extends CrudRepository<Suborders, Long> {

}
