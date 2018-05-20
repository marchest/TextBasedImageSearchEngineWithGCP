package com.xas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xas.common.model.User;
import com.xas.common.service.UserService;
import com.xas.sendmail.EmailService;
import com.xas.sendmail.MessageSender;



@Controller
@RequestMapping(value="/account")
public class SignUpController {

	@Autowired(required=true)
	@Qualifier("userService")
	UserService userService;

	private boolean validateForm() {

		return false;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String SignUp(ModelMap model) {
		System.out.println("xxxxxxx");
		User register=new User();
		model.put("customerData",register);
		return "signup";

	}

	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public String register(@ModelAttribute(value="customerData")User userRegister,ModelMap model,BindingResult br,HttpServletRequest request) {
		if (br.hasErrors()) {
			return "failed";
		}
		//model.addAttribute("name",userRegister.getName()); urle eklenti yapýyor.http://localhost:8080/XASMAIN/hello/Login?name=furkan gibi
		//		System.out.println(request.getRequestURI());
		//		System.out.println(request.getServerPort());
		//		System.out.println(request.getQueryString());
		if (!userService.addUser(userRegister)) {
			model.addAttribute("UnsuccesfulRegistration", userRegister.getUserName()+"&"+userRegister.getSurName());
			return "redirect:/unSuccess/";
		}	
		else {
			MessageSender ms=new MessageSender(new EmailService());
			ms.processMessage("this is test", "kayafurkn@outlook.com", "furkan.kaya@ceng.deu.edu.tr");
			model.addAttribute("SuccessfullyRegistered", userRegister.getUserName()+"&"+userRegister.getSurName());

			return "redirect:/user/Login";

		}



	}
	
	
}
