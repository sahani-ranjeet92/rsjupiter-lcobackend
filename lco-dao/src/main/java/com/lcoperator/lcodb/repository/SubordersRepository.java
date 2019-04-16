
package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Suborders;

@Repository
public interface SubordersRepository extends CrudRepository<Suborders, Long> {

}
