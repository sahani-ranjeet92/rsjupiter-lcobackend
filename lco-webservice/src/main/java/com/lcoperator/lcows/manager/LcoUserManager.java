package com.lcoperator.lcows.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcows.common.UserResponseDto;
import com.lcoperator.lcows.exception.LcoUserException;
import com.lcoperator.lcows.service.LcoUserService;

/**
 * @author ranjeet
 *
 */
@Component
public class LcoUserManager {

	@Autowired
	private LcoUserService lcoUserService;

	public UserResponseDto registerUser(String userName) throws LcoUserException {
		if (userName == null || userName == "")
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "username must not be empty");
		if (lcoUserService.userExist(userName)) {
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "username already registered");
		}
		UserResponseDto userResonseDto = new UserResponseDto();
		userResonseDto.setUserId(lcoUserService.registerUser(userName));
		return userResonseDto;
	}

	public UserResponseDto getUser(String userName) throws LcoUserException {
		return lcoUserService.getUser(userName);
	}

	public List<UserResponseDto> getUserList() {
		Iterable<User> iterator = lcoUserService.getUserList();
		List<UserResponseDto> userList = new ArrayList<UserResponseDto>();
		iterator.forEach(user -> {
			UserResponseDto userResonseDto = new UserResponseDto();
			userResonseDto.setUserId(user.getUserId());
			userResonseDto.setUsername(user.getUsername());
			userResonseDto.setEmail(user.getEmail());
			userResonseDto.setFirstName(user.getFirstName());
			userResonseDto.setLastName(user.getLastName());
			userResonseDto.setGender(user.getGender());
			userResonseDto.setStatus(user.getStatus());
			userResonseDto.setCreatedTimestamp(user.getCreatedTimestamp().getTime());
			userList.add(userResonseDto);
		});
		return userList;
	}

	public UserResponseDto getUserById(Long userId) throws LcoUserException {
		return lcoUserService.getUserById(userId);
	}

}
