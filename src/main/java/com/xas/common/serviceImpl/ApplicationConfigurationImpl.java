package com.xas.common.serviceImpl;

import org.springframework.stereotype.Service;

import com.xas.common.service.ApplicationConfiguration;

@Service("applicationConfiguration")
public class ApplicationConfigurationImpl implements ApplicationConfiguration{

	public static final String USEREMAILONSESSION="useremail";
	
	
	public static final String USERPROFILESESSION="userProfile";
	
	public String returnUserEmailFromSession() {
		
		return USEREMAILONSESSION;
	}

	public String returnUserProfileFromSession() {
		
		return USERPROFILESESSION;
	}

}
