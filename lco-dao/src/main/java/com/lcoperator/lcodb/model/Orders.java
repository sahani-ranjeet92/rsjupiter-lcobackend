package com.lcoperator.lcodb.model;
// Generated Apr 15, 2019 10:50:30 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "orders", catalog = "lco_db")
public class Orders implements java.io.Serializable {

	private Long ordersId;
	private User user;
	private BigDecimal totalproduct;
	private BigDecimal totaltax;
	private String description;
	private Date timeplaced;
	private Date lastupdate;
	private String status;
	private BigDecimal totaladjustment;
	private Long csrUserId;
	private Date expiredate;
	private Integer field1;
	private String field2;
	private String field3;
	private Set<Orderitems> orderitemses = new HashSet<Orderitems>(0);
	private Set<Suborders> suborderses = new HashSet<Suborders>(0);

	public Orders() {
	}

	public Orders(User user, BigDecimal totalproduct, BigDecimal totaltax, Date timeplaced, Date lastupdate,
			String status, BigDecimal totaladjustment, Date expiredate) {
		this.user = user;
		this.totalproduct = totalproduct;
		this.totaltax = totaltax;
		this.timeplaced = timeplaced;
		this.lastupdate = lastupdate;
		this.status = status;
		this.totaladjustment = totaladjustment;
		this.expiredate = expiredate;
	}

	public Orders(User user, BigDecimal totalproduct, BigDecimal totaltax, String description, Date timeplaced,
			Date lastupdate, String status, BigDecimal totaladjustment, Long csrUserId, Date expiredate, Integer field1,
			String field2, String field3, Set<Orderitems> orderitemses, Set<Suborders> suborderses) {
		this.user = user;
		this.totalproduct = totalproduct;
		this.totaltax = totaltax;
		this.description = description;
		this.timeplaced = timeplaced;
		this.lastupdate = lastupdate;
		this.status = status;
		this.totaladjustment = totaladjustment;
		this.csrUserId = csrUserId;
		this.expiredate = expiredate;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.orderitemses = orderitemses;
		this.suborderses = suborderses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ORDERS_ID", unique = true, nullable = false)
	public Long getOrdersId() {
		return this.ordersId;
	}

	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "TOTALPRODUCT", nullable = false, precision = 20, scale = 5)
	public BigDecimal getTotalproduct() {
		return this.totalproduct;
	}

	public void setTotalproduct(BigDecimal totalproduct) {
		this.totalproduct = totalproduct;
	}

	@Column(name = "TOTALTAX", nullable = false, precision = 20, scale = 5)
	public BigDecimal getTotaltax() {
		return this.totaltax;
	}

	public void setTotaltax(BigDecimal totaltax) {
		this.totaltax = totaltax;
	}

	@Column(name = "DESCRIPTION", length = 254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMEPLACED", nullable = false, length = 19)
	public Date getTimeplaced() {
		return this.timeplaced;
	}

	public void setTimeplaced(Date timeplaced) {
		this.timeplaced = timeplaced;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATE", nullable = false, length = 19)
	public Date getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Column(name = "STATUS", nullable = false, length = 3)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "TOTALADJUSTMENT", nullable = false, precision = 20, scale = 5)
	public BigDecimal getTotaladjustment() {
		return this.totaladjustment;
	}

	public void setTotaladjustment(BigDecimal totaladjustment) {
		this.totaladjustment = totaladjustment;
	}

	@Column(name = "CSR_USER_ID")
	public Long getCsrUserId() {
		return this.csrUserId;
	}

	public void setCsrUserId(Long csrUserId) {
		this.csrUserId = csrUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIREDATE", nullable = false, length = 19)
	public Date getExpiredate() {
		return this.expiredate;
	}

	public void setExpiredate(Date expiredate) {
		this.expiredate = expiredate;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
	public Set<Orderitems> getOrderitemses() {
		return this.orderitemses;
	}

	public void setOrderitemses(Set<Orderitems> orderitemses) {
		this.orderitemses = orderitemses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<Suborders> getSuborderses() {
		return this.suborderses;
	}

	public void setSuborderses(Set<Suborders> suborderses) {
		this.suborderses = suborderses;
	}

}
