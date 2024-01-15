package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityHeadersApplicationTests {
	
	@Autowired
	RestTemplate testRestTemplate;
	

	@Test
    public void testGetHello() {
		// Create a RestTemplate instance
				

				// Create a BasicAuthenticationInterceptor with the username and password
				String username = "user";
				String password = "user";
				testRestTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password));
				// Define the URL for the request
				String url = "http://localhost:8080/hello";
				// Send the GET request with authentication headers
				ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, null, String.class);
				// Retrieve the response body
				String responseBody = response.getBody();
				System.out.println(responseBody);
				assert response.getBody().equals("Hello from Vishal");
    }
	
/*
The line testRestTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(username, password)); adds a BasicAuthenticationInterceptor to the list of interceptors for the testRestTemplate object.
In the context of testing, an interceptor is a component that can intercept and modify HTTP requests and responses. It allows you to add additional functionality or modify the behavior of the requests/responses at various stages of the communication.
In this specific case, a BasicAuthenticationInterceptor is being added as an interceptor to the testRestTemplate. This interceptor is responsible for adding basic authentication credentials (username and password) to outgoing HTTP requests.
By adding this interceptor to the testRestTemplate, it ensures that any HTTP requests made through testRestTemplate will include the appropriate basic authentication headers. This is useful when testing endpoints that require authentication.
In summary, the line of code adds a BasicAuthenticationInterceptor as an interceptor to the testRestTemplate, allowing it to include basic authentication credentials in the outgoing HTTP requests.
*/
	
	
	@Test
	public void testGetHello1() {
	    // Create the headers and set the basic authentication credentials
	    HttpHeaders headers = new HttpHeaders();
	    String username = "user";
	    String password = "user";
	    String basicAuth = username + ":" + password;
	    byte[] encodedAuth = Base64.encodeBase64(basicAuth.getBytes(StandardCharsets.UTF_8));
	    String authHeader = "Basic " + new String(encodedAuth);
	    System.out.println(authHeader);
	    headers.set(HttpHeaders.AUTHORIZATION, authHeader);

	    // Define the URL for the request
	    String url = "http://localhost:8080/hello";

	    // Create the HTTP entity with the headers
	    HttpEntity<String> requestEntity = new HttpEntity<>(headers);

	    // Send the GET request with the headers
	    ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

	    // Retrieve the response body
	    String responseBody = response.getBody();
	    assert response.getBody().equals("Hello from Vishal");
	}

	/*
	 In summary, these lines of code convert the username and password into Base64-encoded authentication credentials and create the Authorization header value in the format required for basic authentication. The authHeader string is then used to set the Authorization header in the HttpHeaders object for the HTTP request.
	 In summary, these lines of code convert the username and password into Base64-encoded authentication credentials and create the Authorization header value in the format required for basic authentication. The authHeader string is then used to set the Authorization header in the HttpHeaders object for the HTTP request.
	 */
}
