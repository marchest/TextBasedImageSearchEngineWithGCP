package com.xas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/actions")
public class ActionController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAction() {
		return "action";
	}
	
	
	
}
