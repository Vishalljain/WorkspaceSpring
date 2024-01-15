package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityHeadersApplicationTests3 {
	
	 @Autowired
	    private Controller controller;

	    @Mock
	    private RestTemplate restTemplate;

	    @BeforeEach
	    public void setup() {
	        String username = "user";
	        String password = "user";
	        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
	    }

	    @Test
	    public void testGetHelloWord() {
	        String expectedResponseBody = "Hello from Vishal";
	        String url = "http://localhost:8080/hell111o";

	        // Mock the response from the RestTemplate
	        ResponseEntity<String> responseEntity = ResponseEntity.ok(expectedResponseBody);
	        System.out.println(responseEntity);
	        when(restTemplate.exchange(url, HttpMethod.GET, null, String.class))
	                .thenReturn(responseEntity);

	        // Invoke the method under test
	        String actualResponse = controller.getHelloWord();

	        // Verify the response
	        String expectedResponse = expectedResponseBody + " : success";
	        System.out.println("actualResponse"+actualResponse);
	        System.out.println("expectedResponse"+expectedResponse);
	    }
	
	/*
	 The annotations @Autowired and @Mock serve different purposes in a test class:

@Autowired RestTemplate: This annotation is used to automatically inject a real instance of the RestTemplate bean from the application context. It relies on Spring's dependency injection mechanism to provide the actual RestTemplate instance to be used in the test. The RestTemplate instance obtained through @Autowired will be the real implementation of RestTemplate configured in your application.

@Mock RestTemplate: This annotation is used in combination with a mocking framework like Mockito to create a mock object of the RestTemplate class. It allows you to define the behavior of the mock object, such as setting up mock method invocations and return values. The @Mock annotation creates a mock instance of the RestTemplate class specifically for testing purposes, and it is not connected to the real implementation or the Spring application context.

In summary, the main difference between @Autowired RestTemplate and @Mock RestTemplate is that @Autowired injects a real instance of the RestTemplate from the application context, while @Mock creates a mock instance of the RestTemplate using a mocking framework like Mockito.

In unit tests, it is common to use @Mock to create mock dependencies and define their behavior, as it allows for better control over the dependencies and isolates the code under test. However, in integration tests or when testing against a real service, @Autowired may be used to inject the actual RestTemplate instance configured in the application.
	 */
}
