package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloSecurity {
	
	@GetMapping("/hello")
	public String getHello() {
		System.out.println("Hello");
		return "Hello";
	}
	
	
	@GetMapping("/hi")
	public String getHi() {
		System.out.println("Hi");
		return "Hi this is vishal";
	}

}
