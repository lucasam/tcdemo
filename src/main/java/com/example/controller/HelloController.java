package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fist test controller for sonar tests
 * 
 * @author lucasam
 *
 */
@RestController
public class HelloController {

	public static final String GREET = "Greetings from Spring Boot!";

	/**
	 * Simple method returned from index
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return GREET;
	}
}
