package com.in28minutes.springboot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUserName());
		return "welcome";
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}

}


/*
The getLoggedInUserName1 method you provided is a common method in Spring Security for obtaining the username of the currently authenticated user. Here's how it works:

SecurityContextHolder.getContext().getAuthentication().getPrincipal(): This code retrieves the current authentication context from Spring Security, which holds information about the authenticated user. The getAuthentication() method returns the authentication object, and getPrincipal() returns the principal object associated with the authentication.

if (principal instanceof UserDetails): This line checks whether the principal object is an instance of the UserDetails interface. UserDetails is a common interface provided by Spring Security for representing user details, including the username.

If the principal is an instance of UserDetails, it means that the user is authenticated, and you can safely cast the principal to UserDetails. You then call getUsername() on the UserDetails object to retrieve the username.

If the principal is not an instance of UserDetails, it might be a different type of object, and you return its string representation using principal.toString().

In summary, this method allows you to obtain the username of the currently authenticated user from the Spring Security context. If the user is authenticated, it returns the username; otherwise, it returns a string representation of the principal object.


*/