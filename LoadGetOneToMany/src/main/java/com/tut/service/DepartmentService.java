package com.tut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tut.entity.Department;
import com.tut.entity.Employee;
import com.tut.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
	@Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }
    
    public Department saveDepartment(Department department) {
    	return departmentRepository.save(department);
    }
    
    public List<Department> saveAll(List<Department> department) {
    	return departmentRepository.saveAll(department);
    }
}

