package com.xas.common.service;

import javax.servlet.http.HttpServletRequest;

import com.xas.common.model.UserProfile;

public interface BusinessControllerService {

	public boolean isAvailableUser(String email);
	
	public abstract UserProfile chechCookie(HttpServletRequest request);
}
