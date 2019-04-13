package com.lcoperator.lcodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lcoperator.lcodb.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	boolean existsByUsername(String userName);

	User findByUsername(String userName);

}