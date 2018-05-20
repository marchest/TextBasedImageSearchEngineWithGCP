package com.xas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/unSuccess")
public class UnsuccesfulRegisteration {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public void unsuccesfulPage() {
		System.out.println("asdasd");
	}
	

}
