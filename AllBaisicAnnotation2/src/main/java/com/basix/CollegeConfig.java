package com.basix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {

@Bean
//@Bean(name = {"getColBean","getCollegeBean"})//we can hve 2 names for beans 

public College getColBean() {
	
	College college = new College(hod());
	college.setTeacher(teacher());
	return college;
	
}

@Bean
public Teacher teacher() {
	return new ScienceTeacher();
}

@Bean
public HOD hod() {
	return new HOD();
}
	
	
}
