package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	

    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	//try {
    	System.out.println("printing the students:"+studentRepository.findAll());
    		return studentRepository.findAll();
//    	}catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
//		return studentRepository.findAll();
        
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    
    @PostMapping("/students")
    public List<Student> saveStudent(@RequestBody List<Student> student) {
		return studentRepository.saveAll(student);
    	
    }
    
    @PostMapping("/courses")
    public List<Course> saveCourse(@RequestBody List<Course> course) {
		return courseRepository.saveAll(course);
    	
    }
    
    @GetMapping("/students/{id}")
    public Optional<Student> Students(@PathVariable Long id) {
    	
        return studentRepository.findById(id);
    }

}
