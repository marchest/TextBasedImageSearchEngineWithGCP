package com.xas.common.service;

import com.xas.common.model.UserProfile;

public abstract interface LoadUserProfile {
	
	public abstract UserProfile loadUserProfile(String email,boolean fromSession); 
	public abstract UserProfile loadUserProfile(); 
}
