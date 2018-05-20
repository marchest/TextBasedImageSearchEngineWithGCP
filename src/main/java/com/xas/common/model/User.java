package com.xas.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "userprofile")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="userGuid")
	private String userGuid;
	
	@Id
//	@GenericGenerator(name="kaugen" , strategy="increment")
	//@GeneratedValue(generator="kaugen")
	@Column(name="userId")
	private Integer userId;
	
	
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="userSurName")
	private String surName;
	
	@Column(name="age",nullable=true)
	private Integer age;
	
	@Column(name="email")
	private String email;
	
	@Column(name="InsertDate")
	private Date InsertDate;
	
	@Column(name="UpdateDate",nullable=true)
	private Date UpdateDate;
	
	@Column(name="userIp",nullable=true)
	private String userIp;
	
	@Column(name="accountStatus",nullable=true)
	private String accountStatus;
	
	@Column(name="isSubscriber",nullable=true)
	private String isSubscriber;
	
	@Column(name="password")
	private String password;
	
	@Column(name="lastLoginTime",nullable=true)
	private Date lastLoginTime;
	
	@Column(name="isChangingPassword",nullable=true)
	private String isChangingPassword;
	
	@Column(name="accountUpdateDate",nullable=true)
	private Date accountUpdateDate;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(Date insertDate) {
		InsertDate = insertDate;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getIsSubscriber() {
		return isSubscriber;
	}
	public void setIsSubscriber(String isSubscriber) {
		this.isSubscriber = isSubscriber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getAccountUpdateDate() {
		return accountUpdateDate;
	}
	public void setAccountUpdateDate(Date accountUpdateDate) {
		this.accountUpdateDate = accountUpdateDate;
	}
	public String getUserGuid() {
		return userGuid;
	}
	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}
	public String getIsChangingPassword() {
		return isChangingPassword;
	}
	public void setIsChangingPassword(String isChangingPassword) {
		this.isChangingPassword = isChangingPassword;
	}

	
	
}
