package com.vision.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchModel {
	@JsonProperty
	private String desc;
	@JsonProperty
	private String operator;
	
	

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
