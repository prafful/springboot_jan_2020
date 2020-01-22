package com.springmvc.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstSpringMVCHelloController {

	/**
	 *   /home will be interpreted as home.spring
	 *   because url-pattern is set to *.spring
	 */ 
	@RequestMapping("/home")
	public ModelAndView welcome() {
		/**
		 * it will look for 
		 * prefix + welcome + suffix
		 * i.e. 
		 * /WEB-INF/myviews/hello.jsp
		 */
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "Prafful Daga");
		mv.addObject("location", "Chennai");
		mv.setViewName("hello");
		return mv;
		
		//return "welcome";
		
	}
	
	@RequestMapping("/add")
	public ModelAndView addFriendPage() {
		/**
		 * it will look for 
		 * prefix + welcome + suffix
		 * i.e. 
		 * /WEB-INF/myviews/addpage.jsp
		 */
		ModelAndView mv = new ModelAndView();
		mv.addObject("company", "CTS");
		mv.addObject("branch", "Kochi");
		mv.setViewName("addpage");
		return mv;
	}
	
}
