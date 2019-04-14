package com.lcoperator.lcows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcoperator.lcows.common.LcoResponseInfo;
import com.lcoperator.lcows.common.UserResonseDto;
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

	@PostMapping("/registerUser")
	public ResponseEntity<LcoResponseInfo> registerUser(@RequestParam("mobile") String userName) {
		try {
			UserResonseDto data = manager.registerUser(userName);
			return getSuccessResponseInfo("User Registered Successfully", data, HttpStatus.OK);
		} catch (LcoUserException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getUser")
	public ResponseEntity<LcoResponseInfo> getUser(@RequestParam("mobile") String userName) {
		try {
			UserResonseDto data = manager.getUser(userName);
			return getSuccessResponseInfo(HttpStatus.OK.getReasonPhrase(), data, HttpStatus.OK);
		} catch (LcoUserException ex) {
			return getErrorResponseInfo(ex.getMessage(), ex.getStatus());
		} catch (Exception ex) {
			return getErrorResponseInfo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
