package com.lcoperator.lcodb.model;
// Generated Mar 26, 2019 11:21:18 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "lco_db", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {

	private Long userId;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String status;
	private Date dateOfBirth;
	private Date createdTimestamp;
	private Date updatedDateTime;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Suborders> suborderses = new HashSet<Suborders>(0);

	public User() {
	}

	public User(String username, String password, Date createdTimestamp, Date updatedDateTime) {
		this.username = username;
		this.password = password;
		this.createdTimestamp = createdTimestamp;
		this.updatedDateTime = updatedDateTime;
	}

	public User(String username, String password, String email, String firstName, String lastName, String gender,
			String status, Date dateOfBirth, Date createdTimestamp, Date updatedDateTime, Set<Orders> orderses,
			Set<Suborders> suborderses) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.status = status;
		this.dateOfBirth = dateOfBirth;
		this.createdTimestamp = createdTimestamp;
		this.updatedDateTime = updatedDateTime;
		this.orderses = orderses;
		this.suborderses = suborderses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 126)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 126)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL", length = 126)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "FIRST_NAME", length = 126)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 126)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "GENDER", length = 50)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH", length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIMESTAMP", nullable = false, length = 19)
	public Date getCreatedTimestamp() {
		return this.createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE_TIME", nullable = false, length = 19)
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Suborders> getSuborderses() {
		return this.suborderses;
	}

	public void setSuborderses(Set<Suborders> suborderses) {
		this.suborderses = suborderses;
	}

}
