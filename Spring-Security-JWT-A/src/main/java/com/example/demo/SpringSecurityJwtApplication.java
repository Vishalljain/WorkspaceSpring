package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;



@SpringBootApplication
public class SpringSecurityJwtApplication {
	
	@Autowired
	UserRepository repository;

//as i want to load this method on application start up so i can annotate with 	@PostConstruct .This will work as init method so this list will populate on the db 
@PostConstruct  
	public void initUsers() {
		System.out.println("users are getting added");
        List<User> users = Stream.of(
        	
                new User(101, "javatechie", "password", "javatechie@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        if(!users.isEmpty()) {
        	System.out.println("USERS ARE NOT EMPTY");
        	repository.saveAll(users);
        }
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
}
