package com.tut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tut.entity.Department;
import com.tut.entity.Employee;
import com.tut.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
    
    @PostMapping("/dept")
    public Department saveDept(@RequestBody Department department) {
    	return departmentService.saveDepartment(department);
    }
    
    @PostMapping("/deptList")
    public List<Department> saveEmployeeAll(@RequestBody List<Department> department) {
    	return departmentService.saveAll(department);
    }
    
}

