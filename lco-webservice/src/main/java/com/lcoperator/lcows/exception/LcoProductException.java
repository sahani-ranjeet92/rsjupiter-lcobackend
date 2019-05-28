package com.lcoperator.lcows.exception;

import org.springframework.http.HttpStatus;

public class LcoProductException extends Exception {

	private HttpStatus status;
	private String message;

	public LcoProductException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public LcoProductException(HttpStatus status, String message) {
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
