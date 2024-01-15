package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedirectTest {
	
	  @LocalServerPort
	    private int port;

//    @Test
//    public void testRedirect() {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/initial-url", String.class);
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//
//        // Check if the final URL is as expected (status code 302)
//       assertEquals("http://localhost:8080/target-url", responseEntity.getHeaders().getLocation().toString());
//    }
//    
//    @Test
//    public void testRedirectToTarget() {
//        // Send a GET request to /hello
//    	RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/hello", String.class);
//        // Check the response status code (should be 302 for redirect)
//        assertEquals(HttpStatus.FOUND, response.getStatusCode());
//
//        // Check the final redirected URL (should be /target)
//        assertEquals("http://localhost:" + port + "/target-url", response.getHeaders().getLocation().toString());
//    }
    
    
	  private String baseUrl;

	    private RestTemplate restTemplate;

	    @BeforeEach
	    public void setUp() {
	        baseUrl = "http://localhost:" + port;
	        restTemplate = new RestTemplate();
	    }

	    @Test
	    public void testRedirectToTarget1() {
	        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/hello", String.class);

	        // Check the response status code (should be 302 for redirect)
	        assertEquals(HttpStatus.FOUND, response.getStatusCode());
	    }

	    @Test
	    public void testTargetPage() {
	        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/target-url", String.class);

	        // Check the response status code (should be 200 OK)
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	    }
    
}
