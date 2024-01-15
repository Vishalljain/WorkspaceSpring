package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/log")
    public String home() {
        return "logout";
    }
    
    
   
    
    @GetMapping("/home")
    @ResponseBody
    public String takeData() {
    	return "Hello";
    }

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }

    @GetMapping("/hello")
    public String login() {
    	System.out.println("Inside Login");
        return "login";
    }
    
    @GetMapping("/getSessionId")
    @ResponseBody
    public void getSessionId(HttpServletRequest request) {
        // Get the HttpSession from the HttpServletRequest
    	
        HttpSession session = request.getSession(false); // "false" means don't create a new session if one doesn't exist
        
        
        if (session != null) {
            // Invalidate (clear) the session
            session.invalidate();
        }
        // Retrieve the session ID
        String sessionId = session != null ? session.getId() : "Session not found";

        // You can now use the session ID as needed
        // For example, you can pass it to a view or log it
        System.out.println("Session ID: " + sessionId);

        // Return a view that displays the session ID
        
    }
    
    @GetMapping("user")
    @ResponseBody
    private String getLoggedInUserName1() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
    
    
    
}
