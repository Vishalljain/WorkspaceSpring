package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String username;
    private final String token;
    private static final int MAX_RETRIES = 5;

    public GitHubService(
            RestTemplate restTemplate,
            @Value("${github.api.url}") String apiUrl,
            @Value("${github.api.username}") String username,
            @Value("${github.api.token}") String token
    ) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.username = username;
        this.token = token;
    }

    public ResponseEntity<String> getRepositoriesWithRetry() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        int retryCount = 0;
        ResponseEntity<String> response = null;

        while (retryCount < MAX_RETRIES) {
            RequestEntity<Void> request = RequestEntity
                    .get(apiUrl + "/user/" + username + "/repos")
                    .headers(headers)
                    .build();

            try {
                response = restTemplate.exchange(request, String.class);
                if (response.getStatusCode().is2xxSuccessful()) {
                    // Break out of the loop if the request is successful
                    System.out.println("The response is :"+response.getBody());
                	break;
                }
            } catch (Exception e) {
                // Log the exception for debugging purposes (you might want to log it instead)
                e.printStackTrace();
            }

            retryCount++;

            // You can add a delay between retries if needed
            // For example: Thread.sleep(1000); // 1-second delay
        }

        if (response != null) {
            return response;
        } else {
            // Return an appropriate HTTP status code and error message
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching GitHub repositories after " + MAX_RETRIES + " attempts");
        }
    }
}
