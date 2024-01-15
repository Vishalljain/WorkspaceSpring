package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.entity.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData){
		employeeRepository.saveAll(empData);
		return ResponseEntity.ok("Data Saved");
	}
	
	
	@GetMapping("/getAll")
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	@GetMapping("/get/{empId}")
	public Optional<Employee> getEmployee(@PathVariable Long empId){
		return employeeRepository.findById(empId);
	}

}
