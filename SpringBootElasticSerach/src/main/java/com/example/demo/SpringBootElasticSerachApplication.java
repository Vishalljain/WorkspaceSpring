package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class SpringBootElasticSerachApplication {
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<Customer> customers) {
		customerRepository.saveAll(customers);
		return customers.size();
		
	}
	
	@GetMapping("/findAll")
	public List<Customer> getAllEmployees() {
		return (List<Customer>) customerRepository.findAll();
		 
		
	}
	
	@GetMapping("/findByName/{firstName}")
	public List<Customer> findByFirstName(@PathVariable String firstName){
		return customerRepository.findByFirstname(firstName);
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticSerachApplication.class, args);
	}
	
	

}
