package com.lcoperator.lcodb.model;
// Generated Mar 26, 2019 11:21:18 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Catalog generated by hbm2java
 */
@Entity
@Table(name = "catalog", catalog = "lco_db")
public class Catalog implements java.io.Serializable {

	private Long catalogId;
	private String name;
	private String description;
	private Integer field1;
	private String field2;
	private Set<Catgpenrel> catgpenrels = new HashSet<Catgpenrel>(0);
	private Set<Cattogrp> cattogrps = new HashSet<Cattogrp>(0);

	public Catalog() {
	}

	public Catalog(String name) {
		this.name = name;
	}

	public Catalog(String name, String description, Integer field1, String field2, Set<Catgpenrel> catgpenrels,
			Set<Cattogrp> cattogrps) {
		this.name = name;
		this.description = description;
		this.field1 = field1;
		this.field2 = field2;
		this.catgpenrels = catgpenrels;
		this.cattogrps = cattogrps;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATALOG_ID", unique = true, nullable = false)
	public Long getCatalogId() {
		return this.catalogId;
	}

	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	@Column(name = "NAME", nullable = false, length = 254)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 254)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalog")
	public Set<Catgpenrel> getCatgpenrels() {
		return this.catgpenrels;
	}

	public void setCatgpenrels(Set<Catgpenrel> catgpenrels) {
		this.catgpenrels = catgpenrels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalog")
	public Set<Cattogrp> getCattogrps() {
		return this.cattogrps;
	}

	public void setCattogrps(Set<Cattogrp> cattogrps) {
		this.cattogrps = cattogrps;
	}

}
