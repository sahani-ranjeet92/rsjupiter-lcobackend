package com.lcoperator.lcodb.model;
// Generated Mar 26, 2019 11:21:18 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Catgpenrel generated by hbm2java
 */
@Entity
@Table(name = "catgpenrel", catalog = "lco_db")
public class Catgpenrel implements java.io.Serializable {

	private CatgpenrelId id;
	private Catalog catalog;
	private Catentry catentry;
	private Catgroup catgroup;
	private Date lastupdate;
	private Integer field1;
	private String field2;
	private String field3;

	public Catgpenrel() {
	}

	public Catgpenrel(CatgpenrelId id, Catalog catalog, Catentry catentry, Catgroup catgroup, Date lastupdate) {
		this.id = id;
		this.catalog = catalog;
		this.catentry = catentry;
		this.catgroup = catgroup;
		this.lastupdate = lastupdate;
	}

	public Catgpenrel(CatgpenrelId id, Catalog catalog, Catentry catentry, Catgroup catgroup, Date lastupdate,
			Integer field1, String field2, String field3) {
		this.id = id;
		this.catalog = catalog;
		this.catentry = catentry;
		this.catgroup = catgroup;
		this.lastupdate = lastupdate;
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "catgroupId", column = @Column(name = "CATGROUP_ID", nullable = false)),
			@AttributeOverride(name = "catentryId", column = @Column(name = "CATENTRY_ID", nullable = false)),
			@AttributeOverride(name = "catalogId", column = @Column(name = "CATALOG_ID", nullable = false)) })
	public CatgpenrelId getId() {
		return this.id;
	}

	public void setId(CatgpenrelId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATALOG_ID", nullable = false, insertable = false, updatable = false)
	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATENTRY_ID", nullable = false, insertable = false, updatable = false)
	public Catentry getCatentry() {
		return this.catentry;
	}

	public void setCatentry(Catentry catentry) {
		this.catentry = catentry;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATGROUP_ID", nullable = false, insertable = false, updatable = false)
	public Catgroup getCatgroup() {
		return this.catgroup;
	}

	public void setCatgroup(Catgroup catgroup) {
		this.catgroup = catgroup;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATE", nullable = false, length = 19)
	public Date getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
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