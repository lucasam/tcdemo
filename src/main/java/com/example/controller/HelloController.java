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
	
	public void testNonBlocker(){
		try{
			List<String> list = new ArrayList<String>();
			Integer integer = Integer.valueOf(1);

			if (list.contains(integer)) { // Noncompliant. Always false.
				list.remove(integer); // Noncompliant. list.add(iger) doesn't compile, so this will always return false
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return;
	}	
}
