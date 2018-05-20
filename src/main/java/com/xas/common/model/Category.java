package com.xas.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xas.common.AppUtils.StateConverter;

@Entity
@Table(name = "category")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="categoryId",nullable=false)
	private Integer categoryId;

	@Column(name="categoryName",nullable=false)
	private String categoryName;

	@Column(name="parentCategory",nullable=true)
	private String parentCategory;


	@Column(name="subCategory",nullable=true)
	private String subCategory;
	
	
	@Column(name="State",nullable=true)
	@Enumerated(EnumType.STRING)
	@Convert(converter = StateConverter.class)
	private State categoryState;
	
	@Column(name="userId",nullable=true)
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public State getCategoryState() {
		return categoryState;
	}

	public void setCategoryState(State categoryState) {
		this.categoryState = categoryState;
	}



}
