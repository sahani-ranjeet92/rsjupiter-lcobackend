package com.lcoperator.lcows.common;

import java.util.Date;

public class OrderItemDto {

	private Long orderitemsId;
	private ProductDto product;
	private double productprice;
	private String status;
	private Date lastcreate;
	private Date lastupdate;
	private long offerId;
	private double taxamount;
	private double totaladjustment;

	public Long getOrderitemsId() {
		return orderitemsId;
	}

	public void setOrderitemsId(Long orderitemsId) {
		this.orderitemsId = orderitemsId;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastcreate() {
		return lastcreate;
	}

	public void setLastcreate(Date lastcreate) {
		this.lastcreate = lastcreate;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	public double getTaxamount() {
		return taxamount;
	}

	public void setTaxamount(double taxamount) {
		this.taxamount = taxamount;
	}

	public double getTotaladjustment() {
		return totaladjustment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItemDto [orderitemsId=").append(orderitemsId).append(", product=").append(product)
				.append(", productprice=").append(productprice).append(", status=").append(status)
				.append(", lastcreate=").append(lastcreate).append(", lastupdate=").append(lastupdate)
				.append(", offerId=").append(offerId).append(", taxamount=").append(taxamount)
				.append(", totaladjustment=").append(totaladjustment).append("]");
		return builder.toString();
	}

	public void setTotaladjustment(double totaladjustment) {
		this.totaladjustment = totaladjustment;
	}

}
