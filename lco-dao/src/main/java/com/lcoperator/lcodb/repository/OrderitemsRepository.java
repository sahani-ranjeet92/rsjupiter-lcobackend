package com.lcoperator.lcodb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Orderitems;

@Repository
public interface OrderitemsRepository extends CrudRepository<Orderitems, Long> {

	@Query("From Orderitems oi WHERE oi.orders.ordersId=:orderId and oi.productId=:catentryId and oi.status=:status")
	Orderitems findByProductIdAndStatus(@Param("orderId") Long orderId, @Param("catentryId") Long catentryId,@Param("status") String statusName);

}
