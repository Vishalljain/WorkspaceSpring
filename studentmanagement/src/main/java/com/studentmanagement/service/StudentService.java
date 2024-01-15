package com.studentmanagement.service;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentService {
	
	List<Student> loadStudents();

	void saveStudent(Student student);
	
	Student getStudent(int id);

	void updateStudent(Student student);

	void deleteStudent(int id);
	
	

}
