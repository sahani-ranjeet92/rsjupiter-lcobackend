package com.lcoperator.lcows.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lcoperator.lcows.common.LcoResponseInfo;

public abstract class LcoBaseController {

	public LcoBaseController() {
		super();
	}

	protected ResponseEntity<LcoResponseInfo> getSuccessResponseInfo(String msg, Object data, HttpStatus status) {
		LcoResponseInfo info = new LcoResponseInfo();
		info.setMessage(msg);
		info.setStatus(status.value());
		if (data != null)
			info.setData(data);
		return new ResponseEntity<>(info, status);
	}

	protected ResponseEntity<LcoResponseInfo> getErrorResponseInfo(String msg, HttpStatus status) {
		LcoResponseInfo info = new LcoResponseInfo();
		info.setMessage(msg);
		info.setStatus(status.value());
		return new ResponseEntity<>(info, status);
	}

}