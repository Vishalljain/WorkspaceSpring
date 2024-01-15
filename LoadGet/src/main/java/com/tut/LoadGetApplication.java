package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LoadGetApplication {

	

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		//while getting data from db we dont want any transaction
//		Student student = openSession.get(Student.class, 10);
//		System.out.println("Q : "+student.getName());
//		
//		Student student1 = openSession.get(Student.class, 10);
//		System.out.println("W :" +student1.getName());
		
		Student student3 = openSession.load(Student.class, 10);
		System.out.println("Q : "+student3.getName());
		
		Student student4 = openSession.load(Student.class, 10);
		System.out.println("W :" +student4.getName());
	}

}
