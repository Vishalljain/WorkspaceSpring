package com.tut.service;

import org.springframework.stereotype.Service;

import com.tut.entity.Department;
import com.tut.entity.Employee;
import com.tut.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }
    
    public Employee saveEmployee(Employee employee) {
    	return employeeRepository.save(employee);
    }
    
    
    public List<Employee> saveEmployeeAll(List<Employee> employee) {
    	return employeeRepository.saveAll(employee);
    }
}


