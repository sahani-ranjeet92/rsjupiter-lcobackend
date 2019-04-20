package com.lcoperator.lcows.exception;

import org.springframework.http.HttpStatus;

/**
 * @author ranjeet
 *
 */
public class LcoUserException extends Exception {

	private HttpStatus status;
	private String message;

	public LcoUserException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public LcoUserException(HttpStatus status, String message) {
		super(message);
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
