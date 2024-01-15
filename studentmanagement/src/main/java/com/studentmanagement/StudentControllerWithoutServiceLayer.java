package com.studentmanagement;

/**
package com.studentmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.studentmanagement.DAO.StudentDAO;
import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.entity.Student;

@Controller
public class StudentControllerWithoutServiceLayer {
	
	@Autowired
	StudentDAO studentDAO;//we have already created obj using @Repository so using autowire we are inject the DAO Object
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		List<Student> studentlist = studentDAO.loadStudents();
		
		for(Student student : studentlist) {
			System.out.println(student);
		}
		model.addAttribute("students", studentlist);
		
		return "student-list";
		
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		model.addAttribute("student11",new StudentDTO());
		return "add-student";
		
	}
	
	
	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student) {
		//http://localhost:8081/studentmanagement/save-student?name=vishal&mobile=63662&country=INDIA----WHEN METHOD = GET IN FORM 
		studentDAO.saveStudent(student);
		//return "Student saved successfully....";
		return "redirect:/showStudent";
		
	}
	
	@ResponseBody
	@GetMapping("/thankyou")
	public String greet() {
		return "Thankyou Record got saved!!!!!";
		
	}
	

}
**/