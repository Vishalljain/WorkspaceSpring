package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.studentmanagement.DAO.StudentDAO;
import com.studentmanagement.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO studentDAO;//we have already created the obj studentDAO using @Repository annotation so using autowire we are injecting the DAO Object
	

	@Override
	public List<Student> loadStudents() {
		List<Student> students = studentDAO.loadStudents();
		return students;
	}


	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
		
	}


	@Override
	public Student getStudent(int id) {
		Student student = studentDAO.getStudent(id);
		return student;
	}


	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}


	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
	}

}
