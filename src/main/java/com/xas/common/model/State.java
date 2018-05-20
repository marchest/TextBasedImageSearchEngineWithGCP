package com.xas.common.model;

public enum State {
	ACTIVE("ACTIVE"),PASSIVE("PASSIVE");
	
	private String code;
	
	State(String code) {
		this.code=code;
	}
	
	public String getCode() {
		return this.code;
	}
}
