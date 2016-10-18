package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args)){
			//Do nothing
		}
	}
}
