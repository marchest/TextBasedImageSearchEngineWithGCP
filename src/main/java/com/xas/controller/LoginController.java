package com.xas.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.HttpJspPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xas.common.model.User;
import com.xas.common.model.UserProfile;
import com.xas.common.service.ApplicationConfiguration;
import com.xas.common.service.BusinessControllerService;
import com.xas.common.service.LoadUserProfile;
import com.xas.common.service.UserService;

@Controller
@RequestMapping(value="/user")

public class LoginController implements HttpJspPage{
	
	@Autowired(required=true)
	@Qualifier("userService")
	UserService userService;
	@Autowired
	ApplicationConfiguration appConfig;

	@Autowired(required=true)
	@Qualifier("loadUserProfileService")
	LoadUserProfile loadUserProfile;
	
	@Autowired(required=true)
	@Qualifier("businessControllerService")
	BusinessControllerService bcs;
	
	
	@RequestMapping(value="/Login",method=RequestMethod.GET)
	public String loginCmd() {
System.out.println("login");
		return "redirect:/account/signup#tologin"; //"Login"
	}

	@RequestMapping(value="/Login",method=RequestMethod.POST)
	public  String loginUser(@RequestParam("email") String email,@RequestParam("password")String password,HttpServletRequest request,HttpSession session) {
		
		try {
			
			User user=userService.login(email, password);
			UserProfile userProfile=loadUserProfile.loadUserProfile(email,false);
			session.setAttribute(appConfig.returnUserEmailFromSession(), user.getEmail());
			session.setAttribute(appConfig.returnUserProfileFromSession(), userProfile);
	
		} catch (Exception e) {
			
			return "redirect:/account/signup#tologin";
		}

		return "redirect:/home/";
		
	}

	public void jspDestroy() {
		// TODO Auto-generated method stub
		
	}

	public void jspInit() {
		// TODO Auto-generated method stub
		
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(config.getServletName()+"fasdasxxzx123");
		
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void _jspService(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
