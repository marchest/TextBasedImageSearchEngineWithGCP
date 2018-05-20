package com.xas.common.serviceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xas.common.dao.BusinessControllerDao;
import com.xas.common.model.UserProfile;
import com.xas.common.service.BusinessControllerService;
import com.xas.common.service.LoadUserProfile;


@Service("businessControllerService")
@Scope("prototype")
public class BusinesControllerServiceImpl  implements BusinessControllerService{
	
	@Autowired(required=true)
	@Qualifier("businessControllerDao")
	BusinessControllerDao bcd;
	
	
	@Autowired(required=true)
	@Qualifier("loadUserProfileService")
	LoadUserProfile loadUserProfile;
	
	public boolean isAvailableUser(String email) {
		// TODO Auto-generated method stub
		return bcd.isAvailableUser(email);
	}


	public UserProfile chechCookie(HttpServletRequest request) {
			Cookie [] cookies=request.getCookies();
			UserProfile upf=new UserProfile();
			String email="";
			String password="";
			for (Cookie ck : cookies) {
				if (ck.getName().equalsIgnoreCase("email")) {
					email=ck.getValue();
					
				}
				if (ck.getName().equalsIgnoreCase("password")) {
					password=ck.getValue();
				}
			}
			if (email!="" && password!="") {
				 upf=loadUserProfile.loadUserProfile(email,false);
				
			}
			else
				return null;
		return upf;
	}

}
