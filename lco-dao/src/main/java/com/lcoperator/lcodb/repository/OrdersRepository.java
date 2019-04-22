package com.lcoperator.lcodb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Long> {

	@Query("FROM Orders o WHERE o.user.userId =:userId and o.status =:status")
	Orders findOrder(@Param("userId") Long userId, @Param("status") String statusName);

	@Query("FROM Orders o WHERE o.ordersId =:orderId and  o.user.userId =:userId and o.status =:status")
	Orders findOrder(@Param("orderId") Long orderId, @Param("userId") Long userId, @Param("status") String statusName);

}
