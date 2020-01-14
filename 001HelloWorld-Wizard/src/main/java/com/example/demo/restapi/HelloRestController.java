package com.example.demo.restapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloRestController {
	
	/**
	 * GET Request
	 * http://localhost:8080/
	 * @return
	 */
	@RequestMapping("/")
	public String welcome() {
		return "Hello from Spring Boot!";
	}
	
	/**
	 * GET Request
	 * http://localhost:8080/check
	 * @return
	 */
	@RequestMapping("/check")
	public String sendCheck() {
		return "Check from Spring Boot!";
	}


}
