package com.lcoperator.lcodb.model;
// Generated Apr 15, 2019 10:50:30 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orderitems generated by hbm2java
 */
@Entity
@Table(name = "orderitems", catalog = "lco_db")
public class Orderitems implements java.io.Serializable {

	private Long orderitemsId;
	private Orders orders;
	private User user;
	private long productId;
	private BigDecimal productprice;
	private String status;
	private Date lastcreate;
	private Date lastupdate;
	private long offerId;
	private BigDecimal taxamount;
	private BigDecimal totaladjustment;
	private Integer field1;
	private String field2;
	private String field3;

	public Orderitems() {
	}

	public Orderitems(Orders orders, User user, long productId, BigDecimal productprice, String status, Date lastcreate,
			Date lastupdate, long offerId, BigDecimal taxamount, BigDecimal totaladjustment) {
		this.orders = orders;
		this.user = user;
		this.productId = productId;
		this.productprice = productprice;
		this.status = status;
		this.lastcreate = lastcreate;
		this.lastupdate = lastupdate;
		this.offerId = offerId;
		this.taxamount = taxamount;
		this.totaladjustment = totaladjustment;
	}

	public Orderitems(Orders orders, User user, long productId, BigDecimal productprice, String status, Date lastcreate,
			Date lastupdate, long offerId, BigDecimal taxamount, BigDecimal totaladjustment, Integer field1,
			String field2, String field3) {
		this.orders = orders;
		this.user = user;
		this.productId = productId;
		this.productprice = productprice;
		this.status = status;
		this.lastcreate = lastcreate;
		this.lastupdate = lastupdate;
		this.offerId = offerId;
		this.taxamount = taxamount;
		this.totaladjustment = totaladjustment;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ORDERITEMS_ID", unique = true, nullable = false)
	public Long getOrderitemsId() {
		return this.orderitemsId;
	}

	public void setOrderitemsId(Long orderitemsId) {
		this.orderitemsId = orderitemsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDERS_ID", nullable = false)
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "PRODUCT_ID", nullable = false)
	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	@Column(name = "PRODUCTPRICE", nullable = false, precision = 20, scale = 5)
	public BigDecimal getProductprice() {
		return this.productprice;
	}

	public void setProductprice(BigDecimal productprice) {
		this.productprice = productprice;
	}

	@Column(name = "STATUS", nullable = false, length = 3)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTCREATE", nullable = false, length = 19)
	public Date getLastcreate() {
		return this.lastcreate;
	}

	public void setLastcreate(Date lastcreate) {
		this.lastcreate = lastcreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATE", nullable = false, length = 19)
	public Date getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Column(name = "OFFER_ID", nullable = false)
	public long getOfferId() {
		return this.offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}

	@Column(name = "TAXAMOUNT", nullable = false, precision = 20, scale = 5)
	public BigDecimal getTaxamount() {
		return this.taxamount;
	}

	public void setTaxamount(BigDecimal taxamount) {
		this.taxamount = taxamount;
	}

	@Column(name = "TOTALADJUSTMENT", nullable = false, precision = 20, scale = 5)
	public BigDecimal getTotaladjustment() {
		return this.totaladjustment;
	}

	public void setTotaladjustment(BigDecimal totaladjustment) {
		this.totaladjustment = totaladjustment;
	}

	@Column(name = "FIELD1")
	public Integer getField1() {
		return this.field1;
	}

	public void setField1(Integer field1) {
		this.field1 = field1;
	}

	@Column(name = "FIELD2", length = 128)
	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	@Column(name = "FIELD3", length = 254)
	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
