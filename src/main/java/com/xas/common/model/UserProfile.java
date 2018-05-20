package com.xas.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private Address address;
	
	private List<Category> userCategories;
	
	

	public UserProfile(User user, Address address) {
	
		this.user = user;
	
	}

	public UserProfile() {
		
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Category> getUserCategories() {
		if (userCategories==null) {
			return new ArrayList<Category>();
		}
		return userCategories;
	}

	public void setUserCategories(List<Category> userCategories) {
		this.userCategories = userCategories;
	}	
}
