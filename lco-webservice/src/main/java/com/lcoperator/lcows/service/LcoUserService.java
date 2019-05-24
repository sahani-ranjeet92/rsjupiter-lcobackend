package com.lcoperator.lcows.service;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcows.common.UserResonseDto;
import com.lcoperator.lcows.exception.LcoUserException;

public interface LcoUserService {

	long registerUser(String userName);

	boolean userExist(String userName);

	UserResonseDto getUser(String userName) throws LcoUserException;

	Iterable<User> getUserList();

}
