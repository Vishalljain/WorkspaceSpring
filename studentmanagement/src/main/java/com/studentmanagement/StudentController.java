package com.studentmanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;



//Note--->Controller->Service->DAO->DB(Controller talk to service, service talk to dao and dao interact with db)
@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;//we have already created obj studentService using @Service so using autowire we are inject the DAO Object
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		List<Student> studentlist = studentService.loadStudents();
		
		for(Student student : studentlist) {
			//System.out.println(student);
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
	public String saveStudent(Student student) {
		//http://localhost:8081/studentmanagement/save-student?name=vishal&mobile=63662&country=INDIA----WHEN METHOD = GET IN FORM 
		System.out.println(student);
		if(student.getId()==0) {
			System.out.println("save method called");
			studentService.saveStudent(student);
		}
		else {
			System.out.println("update method called");
			studentService.updateStudent(student);
		}
		
		return "redirect:/showStudent";
		
	}
	
	@ResponseBody
	@GetMapping("/thankyou")
	public String greet() {
		return "Thankyou Record got saved!!!!!";
		
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam ("userId") int id,Model model) {
		//
		System.out.println("we are looking for the id : "+ id);
		
		Student student = studentService.getStudent(id);
		model.addAttribute("student11",student);
		
		
		return "add-student";
		
	}
	//or above method short form
	
//	@GetMapping("/updateStudent")
//	public String updateStudent(@RequestParam ("userId") int id,@ModelAttribute("student11")StudentDTO studentdto) {
//		System.out.println("we are looking for the id : "+ id);
//		
//		Student student = studentService.getStudent(id);
//		System.out.println(student);
//		
//		studentdto.setName(student.getName());
//		studentdto.setCountry(student.getCountry());
//		studentdto.setMobile(student.getMobile());
//		return "add-student";
//		
//	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam ("userId") int id) {//dont need a model right now because i dont want to send any data to anywhere
		System.out.println("deleted");
		studentService.deleteStudent(id);
		return "redirect:/showStudent";
		
	}
	

}
