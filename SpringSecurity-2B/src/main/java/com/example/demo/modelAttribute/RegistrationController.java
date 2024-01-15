package com.example.demo.modelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @ModelAttribute("user") // This method sets up a User object in the model
    public User getDefaultUser() {
        return new User();
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registrationForm"; // Display the registration form
    }

    @PostMapping("/wow")
    public String processRegistrationForm(@ModelAttribute("user") User user) {
        // Handle form submission and user registration logic
        // For simplicity, we'll just print the user's details
    	System.out.println("Inside");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        return "registrationSuccess"; // Redirect to a success page
    }
  
}

