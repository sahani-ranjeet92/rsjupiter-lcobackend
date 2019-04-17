package com.lcoperator.lcows.common;

public enum OrderStatusEnum {

	NEW("N"), COMPLETED("C");

	private String statusName;

	private OrderStatusEnum(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}

}
