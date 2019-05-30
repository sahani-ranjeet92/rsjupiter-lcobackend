package com.lcoperator.lcows.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.lcoperator.lcodb.model.User;
import com.lcoperator.lcows.common.UserResonseDto;
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

	public UserResonseDto registerUser(String userName) throws LcoUserException {
		if (userName == null || userName == "")
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "username must not be empty");
		if (lcoUserService.userExist(userName)) {
			throw new LcoUserException(HttpStatus.BAD_REQUEST, "username already registered");
		}
		UserResonseDto userResonseDto = new UserResonseDto();
		userResonseDto.setUserId(lcoUserService.registerUser(userName));
		return userResonseDto;
	}

	public UserResonseDto getUser(String userName) throws LcoUserException {
		return lcoUserService.getUser(userName);
	}

	public List<UserResonseDto> getUserList() {
		Iterable<User> iterator = lcoUserService.getUserList();
		List<UserResonseDto> userList = new ArrayList<UserResonseDto>();
		iterator.forEach(user -> {
			UserResonseDto userResonseDto = new UserResonseDto();
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

}
