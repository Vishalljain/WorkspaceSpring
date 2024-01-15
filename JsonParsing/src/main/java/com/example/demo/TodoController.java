package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<Todo[]> getTodos() {
        Todo[] todos = todoService.getTodos();

        // Process the todos as needed
        for (Todo todo : todos) {
            // Your processing logic here
            System.out.println(todo);
        }

        return ResponseEntity.ok(todos);
    }
}

