package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello";
		
	}
	
	@ResponseBody
	@GetMapping("/hello1")
	public String helloWorld1() {
		return "hello Word";
		
	}

}
