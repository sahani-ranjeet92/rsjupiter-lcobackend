package com.lcoperator.lcows.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcodb.repository.UserRepository;
import com.lcoperator.lcows.common.UserResonseDto;
import com.lcoperator.lcows.exception.LcoUserException;
import com.lcoperator.lcows.service.LcoUserService;

@Service
public class LcoUserServiceImpl implements LcoUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public long registerUser(String userName) {
		User user = new User();
		user.setUsername(userName);
		user.setPassword("Login1-2");
		Date createdTimestamp = new Date();
		user.setCreatedTimestamp(createdTimestamp);
		user.setUpdatedDateTime(createdTimestamp);
		User userSave = userRepository.save(user);
		return userSave == null ? 0 : userSave.getUserId();
	}

	@Override
	public boolean userExist(String userName) {
		return userRepository.existsByUsername(userName);
	}

	@Override
	public UserResonseDto getUser(String userName) throws LcoUserException {
		User user = userRepository.findByUsername(userName);
		if(user == null){
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "user not exist");
		}
		UserResonseDto response = new UserResonseDto();
		response.setUserId(user.getUserId());
		return response;
	}

}
