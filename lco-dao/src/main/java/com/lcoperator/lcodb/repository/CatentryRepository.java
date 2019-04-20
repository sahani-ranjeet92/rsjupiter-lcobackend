package com.lcoperator.lcodb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Catentry;

@Repository
public interface CatentryRepository extends CrudRepository<Catentry, Long> {

	@Query("FROM Catentry c WHERE c.catentryId IN(:productIds)")
	List<Catentry> findAllChannels(@Param("productIds") List<Long> productIds);

}
