package springMVC;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeContoller {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("This is in controller");
		return "index";
	}
	
	@RequestMapping("/backendtoui")
	public String ex(Model model) {
		model.addAttribute("name", "vishal");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("y");
		list.add("z");
		model.addAttribute("alphabets",list);
		
		return "about";
	}
	
	
	@RequestMapping("/backendtouianotherway")
    public ModelAndView help() {
		ModelAndView modelAndView = new ModelAndView();
		//setting the data
		modelAndView.addObject("name","hello Vishal");
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("date", now);
		//setting the view
		modelAndView.setViewName("help");
		return modelAndView;
		
	}
	
	
	//Insted of suing request.getAttribute use ${} and to traverse any list instead of for used jstl tag
	
	@RequestMapping("/jstl1")
    public ModelAndView help1() {
		ModelAndView modelAndView = new ModelAndView();
		//setting the data
		modelAndView.addObject("name","hello Vishal");
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("date", now);
		//setting the view
		modelAndView.setViewName("help");
		return modelAndView;
		
	}
}
