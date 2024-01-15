package spring.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{
	
	//this class is required is to initialized or Register the filter chain which u have created in MySecurityConfig.java....in simple terms it will make the gun man / filter chain stand in front of our app..

}



//By using Spring Boot, you don't have to worry about adding the Spring Security filter to your application's web.xml file, or registering the Spring Security configuration class with your application's context, Spring Boot automatically configures Spring Security for you.