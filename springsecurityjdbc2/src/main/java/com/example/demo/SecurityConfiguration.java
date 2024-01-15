package com.example.demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	DataSource dataSource;//SPRING WILL SEE H2 IN CLASS PATH N CONFIGURE
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		//HERE WE HVE USED DEFAALUT SCHEMA SO SPRING SECURITY WILL TAKE CARE OF TABLE CREATION
		//https://docs.spring.io/spring-security/reference/servlet/appendix/database-schema.html----default schema created by spring
		auth.jdbcAuthentication().dataSource(dataSource);
		
		//or
		//auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from users where username=?").authoritiesByUsernameQuery("select username,authority from authorities where username=?" );
		
	}
	
	  @Bean
	    public PasswordEncoder getPasswordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                .antMatchers("/admin").hasRole("ADMIN")
	                .antMatchers("/user").hasRole("USER")
	                .antMatchers("/").permitAll()
	                .and().formLogin();
	    }
	
	

}
/*
protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		//if u want to change table from users to my_user put select * from my_user
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,enabled from users where username=?").authoritiesByUsernameQuery("select username,authority from authorities where username=?" );
	}



*/