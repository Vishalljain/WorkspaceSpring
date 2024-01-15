package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodoService {

    @Value("${jsonplaceholder.url}")
    private String jsonPlaceholderUrl;

    public Todo[] getTodos() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(jsonPlaceholderUrl + "/todos", Todo[].class);
    }

    // Process the todos as needed
    public void processTodos() {
        Todo[] todos = getTodos();
        for (Todo todo : todos) {
            // Your processing logic here
            System.out.println("Processing Todo: " + todo.getTitle());
        }
    }
}
