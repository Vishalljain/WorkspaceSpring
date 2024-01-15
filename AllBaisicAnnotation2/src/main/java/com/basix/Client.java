package com.basix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CollegeConfig.class);
		System.out.println("Config file loaded");
		College college = applicationContext.getBean("getColBean",College.class);
		college.test();
	}

}
