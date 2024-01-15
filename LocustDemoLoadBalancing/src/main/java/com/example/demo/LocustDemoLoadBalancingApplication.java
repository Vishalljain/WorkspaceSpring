package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LocustDemoLoadBalancingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocustDemoLoadBalancingApplication.class, args);
	}

}
@RestController
class RandomResource {

    @GetMapping(value = "/greet")
    public String greet() {
        return "Locust Load Test.";
    }
}
