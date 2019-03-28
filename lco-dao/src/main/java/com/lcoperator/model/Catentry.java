package com.lcoperator.model;
// Generated Mar 26, 2019 11:21:18 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Catentry generated by hbm2java
 */
@Entity
@Table(name = "catentry", catalog = "lco_db", uniqueConstraints = @UniqueConstraint(columnNames = "CHNUMBER"))
public class Catentry implements java.io.Serializable {

	private Long catentryId;
	private String chnumber;
	private String chname;
	private int markfordelete;
	private String url;
	private Date lastupdate;
	private Integer buyable;
	private Date startdate;
	private Date enddate;
	private Date availabilitydate;
	private Date discontinuedate;
	private Integer field1;
	private String field2;
	private String field3;
	private Set<Catgpenrel> catgpenrels = new HashSet<Catgpenrel>(0);

	public Catentry() {
	}

	public Catentry(String chnumber, String chname, int markfordelete, Date lastupdate, Date startdate, Date enddate,
			Date availabilitydate, Date discontinuedate) {
		this.chnumber = chnumber;
		this.chname = chname;
		this.markfordelete = markfordelete;
		this.lastupdate = lastupdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.availabilitydate = availabilitydate;
		this.discontinuedate = discontinuedate;
	}

	public Catentry(String chnumber, String chname, int markfordelete, String url, Date lastupdate, Integer buyable,
			Date startdate, Date enddate, Date availabilitydate, Date discontinuedate, Integer field1, String field2,
			String field3, Set<Catgpenrel> catgpenrels) {
		this.chnumber = chnumber;
		this.chname = chname;
		this.markfordelete = markfordelete;
		this.url = url;
		this.lastupdate = lastupdate;
		this.buyable = buyable;
		this.startdate = startdate;
		this.enddate = enddate;
		this.availabilitydate = availabilitydate;
		this.discontinuedate = discontinuedate;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
		this.catgpenrels = catgpenrels;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CATENTRY_ID", unique = true, nullable = false)
	public Long getCatentryId() {
		return this.catentryId;
	}

	public void setCatentryId(Long catentryId) {
		this.catentryId = catentryId;
	}

	@Column(name = "CHNUMBER", unique = true, nullable = false, length = 64)
	public String getChnumber() {
		return this.chnumber;
	}

	public void setChnumber(String chnumber) {
		this.chnumber = chnumber;
	}

	@Column(name = "CHNAME", nullable = false, length = 128)
	public String getChname() {
		return this.chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}

	@Column(name = "MARKFORDELETE", nullable = false)
	public int getMarkfordelete() {
		return this.markfordelete;
	}

	public void setMarkfordelete(int markfordelete) {
		this.markfordelete = markfordelete;
	}

	@Column(name = "URL", length = 254)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATE", nullable = false, length = 19)
	public Date getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Column(name = "BUYABLE")
	public Integer getBuyable() {
		return this.buyable;
	}

	public void setBuyable(Integer buyable) {
		this.buyable = buyable;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE", nullable = false, length = 19)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "AVAILABILITYDATE", nullable = false, length = 19)
	public Date getAvailabilitydate() {
		return this.availabilitydate;
	}

	public void setAvailabilitydate(Date availabilitydate) {
		this.availabilitydate = availabilitydate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DISCONTINUEDATE", nullable = false, length = 19)
	public Date getDiscontinuedate() {
		return this.discontinuedate;
	}

	public void setDiscontinuedate(Date discontinuedate) {
		this.discontinuedate = discontinuedate;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catentry")
	public Set<Catgpenrel> getCatgpenrels() {
		return this.catgpenrels;
	}

	public void setCatgpenrels(Set<Catgpenrel> catgpenrels) {
		this.catgpenrels = catgpenrels;
	}

}