package com.lcoperator.lcows.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcodb.repository.UserRepository;
import com.lcoperator.lcows.common.UserResponseDto;
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
	public UserResponseDto getUser(String userName) throws LcoUserException {
		User user = userRepository.findByUsername(userName);
		if (user == null) {
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "user not exist");
		}
		return mapUserToUserResponseDto(user);
	}

	@Override
	public Iterable<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public UserResponseDto getUserById(Long userId) throws LcoUserException {
		Optional<User> userOptional = userRepository.findById(userId);

		if (!userOptional.isPresent()) {
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "user not exist");
		}

		return mapUserToUserResponseDto(userOptional.get());

	}

	private UserResponseDto mapUserToUserResponseDto(User user) {
		UserResponseDto response = new UserResponseDto();
		response.setUserId(user.getUserId());
		response.setCreatedTimestamp(user.getCreatedTimestamp() == null ? null : user.getCreatedTimestamp().getTime());
		response.setDateOfBirth(user.getDateOfBirth() == null ? 0 : user.getDateOfBirth().getTime());
		response.setEmail(user.getEmail());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setGender(user.getGender());
		response.setStatus(user.getStatus());
		response.setUsername(user.getUsername());
		return response;
	}

}
