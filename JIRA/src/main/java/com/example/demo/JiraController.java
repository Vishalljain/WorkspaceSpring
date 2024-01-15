package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

@Controller
public class JiraController {

    @GetMapping("/initial-url")
    public String redirectToTarget() {
        return "redirect:/target-url";
    }
    @ResponseBody
    @GetMapping("/target-url")
    public String targetPage() {
        return "target";
    }
    
    @GetMapping("/hello")
    public String redirectToTarget1() {
        return "redirect:/target-url";
    }
}
