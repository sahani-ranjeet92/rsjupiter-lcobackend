package com.lcoperator.lcows.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RemoveOrderItemReqDto {
	private Long orderItemId;
	private Long userId;
	private Long orderId;

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("orderItemId", orderItemId).append("userId", userId)
				.append("orderId", orderId).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(orderItemId).append(userId).append(orderId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof RemoveOrderItemReqDto) == false) {
			return false;
		}
		RemoveOrderItemReqDto rhs = ((RemoveOrderItemReqDto) other);
		return new EqualsBuilder().append(orderItemId, rhs.orderItemId).append(userId, rhs.userId)
				.append(orderId, rhs.orderId).isEquals();
	}
}
