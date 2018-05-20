package com.xas.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "useraddress")
public class Action {
	
	@Id
	@Column(name="actionId",nullable=false)
	private Integer actionId; 
	
	@Column(name="actionName",nullable=false)
	private String actionName;
	
	
	@Column(name="categoryName",nullable=false)
	private String categoryName;
	
	@Column(name="userId",nullable=false)
	private Integer userId;

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
