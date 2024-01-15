package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello from Vishal";
		
	}
	
	@GetMapping("/helloWord")
    public String getHelloWord() {
		// Create a RestTemplate instance

		// Create a BasicAuthenticationInterceptor with the username and password
		String username = "user";
		String password = "user";
		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));

		// Define the URL for the request
		String url = "http://localhost:8080/hello";

		// Send the GET request with authentication headers
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		// Retrieve the response body
		String responseBody = response.getBody();

		// Print the response
		return responseBody + " : "+ "success";

    }
	
	
	/*
	 ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
	 url: The URL of the resource you want to access (http://localhost:8080/hello in this case).
	 HttpMethod.GET: The HTTP method to be used (GET in this case).
	 null: The request entity. Since there is no request body or additional headers, null is passed as the request entity.
	 String.class: The expected response type. In this case, you expect a String response body.
	 */
	

}