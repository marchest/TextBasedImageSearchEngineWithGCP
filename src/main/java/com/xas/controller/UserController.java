package com.xas.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xas.common.model.User;
import com.xas.common.model.UserProfile;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	LoadUserProfile loadUserProfile;
	@Autowired
	ApplicationConfiguration appConfig;
	
	@Autowired
	HttpSession session;
	
	 @RequestMapping(value = "/profile", method = RequestMethod.GET)
	    public String listUsers(ModelMap model) {
		 if (session.getAttribute(appConfig.returnUserProfileFromSession())!=null) {
			 UserProfile userDetail=loadUserProfile.loadUserProfile();
			 
			 model.put("userDetail",userDetail);
		        return "profile";	
		}
		 else
			 return"redirect:/";
	    }
	 
	 
	
}
