package com.lcoperator.lcodb.model;
// Generated Apr 17, 2019 11:00:48 PM by Hibernate Tools 5.1.0.Alpha1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Offerprice generated by hbm2java
 */
@Entity
@Table(name = "offerprice", catalog = "lco_db")
public class Offerprice implements java.io.Serializable {

	private Long offerId;
	private Catentry catentry;
	private Date startdate;
	private Date enddate;
	private double precedence;
	private int published;
	private Date lastupdate;
	private BigDecimal price;
	private String pricetype;
	private Integer field1;
	private String field2;
	private String field3;

	public Offerprice() {
	}

	public Offerprice(Catentry catentry, Date startdate, Date enddate, double precedence, int published,
			Date lastupdate, BigDecimal price) {
		this.catentry = catentry;
		this.startdate = startdate;
		this.enddate = enddate;
		this.precedence = precedence;
		this.published = published;
		this.lastupdate = lastupdate;
		this.price = price;
	}

	public Offerprice(Catentry catentry, Date startdate, Date enddate, double precedence, int published,
			Date lastupdate, BigDecimal price, String pricetype, Integer field1, String field2, String field3) {
		this.catentry = catentry;
		this.startdate = startdate;
		this.enddate = enddate;
		this.precedence = precedence;
		this.published = published;
		this.lastupdate = lastupdate;
		this.price = price;
		this.pricetype = pricetype;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "OFFER_ID", unique = true, nullable = false)
	public Long getOfferId() {
		return this.offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATENTRY_ID", nullable = false)
	public Catentry getCatentry() {
		return this.catentry;
	}

	public void setCatentry(Catentry catentry) {
		this.catentry = catentry;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdate", nullable = false, length = 19)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE", nullable = false, length = 19)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "PRECEDENCE", nullable = false, precision = 22, scale = 0)
	public double getPrecedence() {
		return this.precedence;
	}

	public void setPrecedence(double precedence) {
		this.precedence = precedence;
	}

	@Column(name = "PUBLISHED", nullable = false)
	public int getPublished() {
		return this.published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATE", nullable = false, length = 19)
	public Date getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Column(name = "PRICE", nullable = false, precision = 20, scale = 5)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "PRICETYPE", length = 16)
	public String getPricetype() {
		return this.pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
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

	@Column(name = "FIELD3", length = 256)
	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}