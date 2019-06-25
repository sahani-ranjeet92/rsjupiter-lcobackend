package com.lcoperator.lcows.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcows.common.LcoResponseInfo;
import com.lcoperator.lcows.common.UserResponseDto;
import com.lcoperator.lcows.exception.LcoUserException;
import com.lcoperator.lcows.manager.LcoUserManager;

/**
 * @author ranjeet
 *
 */
@RestController
@RequestMapping("/lco-user")
public class LcoUserController extends LcoBaseController {

	@Autowired
	private LcoUserManager manager;

	@PostMapping(value = "/registerUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> registerUser(@RequestParam("userName") String userName) {
		try {
			UserResponseDto data = manager.registerUser(userName);
			return getSuccessResponseInfo("User Registered Successfully", data, HttpStatus.OK);
		} catch (LcoUserException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> getUser(@RequestParam("userName") String userName) {
		try {
			UserResponseDto data = manager.getUser(userName);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (LcoUserException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getUserDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> getUserDetail(@RequestParam("userId") Long userId) {
		try {
			UserResponseDto data = manager.getUserById(userId);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (LcoUserException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			ex.printStackTrace();
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getUserList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LcoResponseInfo> getUserList() {
		try {
			List<UserResponseDto> data = manager.getUserList();
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
