package com.basix;

import org.springframework.stereotype.Component;


public class College {
	
	//public Principle principle;//java.lang.NullPointerException
	public Principle principle = new Principle();
	public HOD hod;
	public Teacher teacher;
	
	
	
	public College(HOD hod) {
		this.hod = hod;
	}

	public Teacher myTeacher;

	public void test() {
		teacher.teacherName();
		hod.HODInfo();
		principle.principalInfo();
		System.out.println("Testing the call method using @Bean");
		
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
