package com.xas.common.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.xas.common.dao.AddressDao;

import com.xas.common.model.User;
import com.xas.common.model.UserProfile;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.CategoryService;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.UserService;


@Service("loadUserProfileService")
public class UserProfileImpl implements LoadUserProfile {

	@Autowired(required=true)
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired 
	private HttpSession httpSession;

	@Autowired(required=true)
	@Qualifier("addressDao")
	AddressDao addressDao;
	
	@Autowired
	ApplicationConfiguration appConfig;
	
	public UserProfile loadUserProfile(String email,boolean fromSession) {
		UserProfile up=new UserProfile();
		User user=null;
		if (httpSession.getAttribute("userProfile")!=null && fromSession ) {
			
			return (UserProfile)httpSession.getAttribute("userProfile");
		}
		else {
			user=userService.findByEmail(email);
			up.setUser(user);
			up.setAddress(addressDao.findAddress(user.getUserId()));
			up.setUserCategories(categoryService.userCategories(user.getUserGuid()));
			httpSession.setAttribute(appConfig.returnUserProfileFromSession(), up);
			
		}
		return up;
	}
	
	
	public UserProfile loadUserProfile() {
		UserProfile up=new UserProfile();
		if (httpSession.getAttribute("userProfile")!=null) {
			
			return (UserProfile)httpSession.getAttribute("userProfile");
		}
	
		return up;
	}
	
}
