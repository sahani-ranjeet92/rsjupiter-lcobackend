package com.lcoperator.lcows.service;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcows.common.UserResponseDto;
import com.lcoperator.lcows.exception.LcoUserException;

public interface LcoUserService {

	long registerUser(String userName);

	boolean userExist(String userName);

	UserResponseDto getUser(String userName) throws LcoUserException;

	Iterable<User> getUserList();

	UserResponseDto getUserById(Long userId) throws LcoUserException;

}
