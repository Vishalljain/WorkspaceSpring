package com.studentmanagement.DAO;

import java.util.List;

import com.studentmanagement.entity.Student;

public interface StudentDAO {
	
	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	void updateStudent(Student student);
	public void deleteStudent(int id); 
}
