package com.lcoperator.lcows.common;

public enum OrderStatusEnum {

	NEW("N"), COMPLETED("C");

	private String status;

	private OrderStatusEnum(String statusName) {
		this.status = statusName;
	}

	public String getStatus() {
		return status;
	}

}
