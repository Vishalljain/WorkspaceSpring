package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome11")
    public String welcome() {
        return "welcome"; // Returns the welcome.jsp page
    }
}

