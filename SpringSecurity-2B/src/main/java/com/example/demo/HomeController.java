package com.example.demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

	@Controller
	public class HomeController {

	    @GetMapping("/greeting")
	    public String greeting(Model model) {
	        model.addAttribute("message", "Hello, Greet!");
	        return "greeting";
	    }

	    @GetMapping("/confidential")
	    public String confidential(HttpServletRequest request, Model model) {
	        HttpSession session = request.getSession(false);

	        if (session != null) {
	            // Get the session ID
	            String sessionId = session.getId();
	            model.addAttribute("sessionId", sessionId);

	            // Get the user's name
	            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	            String username = auth.getName();
	            model.addAttribute("username", username);
	        }

	        return "confidential";
	    }
	    
	    @GetMapping("/config")
	    public String showUserDataFromJSP() {
			return "config";
	    	
	    }
	    
//	    @GetMapping("/login")
//	    public String loginPage() {
//	    	return "login";
//	    }
	    
	}


