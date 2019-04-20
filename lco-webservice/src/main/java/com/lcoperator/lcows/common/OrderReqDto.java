package com.lcoperator.lcows.common;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderReqDto {

	private List<Long> productIds = null;
	private Long userId;
	private List<Long> packageId = null;

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getPackageId() {
		return packageId;
	}

	public void setPackageId(List<Long> packageId) {
		this.packageId = packageId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("productIds", productIds).append("userId", userId)
				.append("packageId", packageId).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(productIds).append(userId).append(packageId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OrderReqDto) == false) {
			return false;
		}
		OrderReqDto rhs = ((OrderReqDto) other);
		return new EqualsBuilder().append(productIds, rhs.productIds).append(userId, rhs.userId)
				.append(packageId, rhs.packageId).isEquals();
	}

}