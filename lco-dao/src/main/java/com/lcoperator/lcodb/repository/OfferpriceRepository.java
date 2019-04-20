package com.lcoperator.lcodb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Offerprice;

@Repository
public interface OfferpriceRepository extends CrudRepository<Offerprice, Long> {

	@Query("FROM Offerprice op WHERE op.catentry.catentryId = :prodId and op.pricetype = :pricetype ORDER BY op.precedence")
	List<Offerprice> findOfferPrice(@Param("prodId") Long prodId, @Param("pricetype") String priceType);

}
