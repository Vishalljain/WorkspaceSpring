package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityHeadersApplicationTests2 {
	
	@MockBean
    private RestTemplate restTemplate;

    private Controller controller;

    @BeforeEach
    public void setup() {
        controller = new Controller();
        controller.restTemplate = restTemplate;
    }

    @Test
    public void testGetHelloWord() {
        String expectedResponseBody = "Hello from Vishal";
        String url = "http://localhost:8080/hello";

        // Mock the response from the RestTemplate
        ResponseEntity<String> responseEntity = ResponseEntity.ok(expectedResponseBody);
        System.out.println(responseEntity);
        when(restTemplate.exchange(url, HttpMethod.GET, null, String.class))
                .thenReturn(responseEntity);

        // Invoke the method under test
        String actualResponse = controller.getHelloWord();
        System.out.println("actualResponse"+actualResponse);
       
        // Verify the response
        String expectedResponse = expectedResponseBody + " : success";
        System.out.println("expectedResponseBody"+expectedResponse);
       assert responseEntity.getBody().equals(expectedResponse);
    }
	

	
	
}
