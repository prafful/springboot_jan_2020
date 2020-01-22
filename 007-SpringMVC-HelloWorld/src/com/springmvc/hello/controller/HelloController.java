package com.springmvc.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String welcome() {
		/**
		 * it will look for 
		 * prefix + welcome + suffix
		 * i.e. 
		 * /WEB-INF/myviews/welcome.jsp
		 */
		
		return "welcome";
	}
	
}
