package com.studentmanagement.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entity.Student;


@Repository
public class StudentDaoImpl implements StudentDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
		String sql = "select * from students";//this query gives resultset so i need to map the result set to java obj to do tat i need a mapper so we use rowmapper
		List<Student> listOfStudents = jdbcTemplate.query(sql,new StudentRowMapper());
		return listOfStudents;
	}

	@Override
	public void saveStudent(Student student) {
		Object[] sqlParameters = {student.getName(),student.getMobile(),student.getCountry()};
		String sql = "insert into students(name,mobile,country)values(?,?,?)";
		jdbcTemplate.update(sql,sqlParameters);
		System.out.println("1 record saved...");
		
	}

	@Override
	public Student getStudent(int id) {
		String sql = "Select * from students where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "UPDATE STUDENTS SET name=?,mobile=?,country=? where id =?";
		int update = jdbcTemplate.update(sql,student.getName(),student.getMobile(),student.getCountry(),student.getId());
		System.out.println(update+" : record updated");
		
	}

	@Override
	public void deleteStudent(int id) {
		String sql = "delete FROM STUDENTS WHERE ID = ?";
		int update = jdbcTemplate.update(sql,id);
		System.out.println(update+" : record deleted");
		
	}

}
