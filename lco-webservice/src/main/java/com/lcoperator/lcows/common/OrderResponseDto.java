package com.lcoperator.lcows.common;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderResponseDto {

	private List<OrderItemDto> channels = null;
	private List<PackageInfo> packages = null;
	private Long userId;
	private Long orderId;
	private double totalPrice;
	private double totalTax;
	private String orderStatus;
	private String creationDate;
	private String lastUpdate;
	private int quantity;

	public List<OrderItemDto> getChannels() {
		return channels;
	}

	public void setChannels(List<OrderItemDto> channels) {
		this.channels = channels;
	}

	public List<PackageInfo> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageInfo> packages) {
		this.packages = packages;
	}

	public Long getUserId() {
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("channels", channels).append("packages", packages)
				.append("userId", userId).append("orderId", orderId).append("totalPrice", totalPrice)
				.append("totalTax", totalTax).append("orderStatus", orderStatus).append("creationDate", creationDate)
				.append("lastUpdate", lastUpdate).append("quantity", quantity).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(creationDate).append(packages).append(lastUpdate).append(userId)
				.append(channels).append(totalTax).append(orderStatus).append(orderId).append(totalPrice).append(quantity).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OrderResponseDto) == false) {
			return false;
		}
		OrderResponseDto rhs = ((OrderResponseDto) other);
		return new EqualsBuilder().append(creationDate, rhs.creationDate).append(packages, rhs.packages)
				.append(lastUpdate, rhs.lastUpdate).append(userId, rhs.userId).append(channels, rhs.channels)
				.append(totalTax, rhs.totalTax).append(orderStatus, rhs.orderStatus).append(orderId, rhs.orderId)
				.append(totalPrice, rhs.totalPrice).append(quantity, rhs.quantity).isEquals();
	}

}