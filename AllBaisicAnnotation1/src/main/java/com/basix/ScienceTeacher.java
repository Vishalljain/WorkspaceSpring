package com.basix;

import org.springframework.stereotype.Component;

@Component
public class ScienceTeacher implements Teacher{

	@Override
	public void teacherName() {
		System.out.println("Biology Teacher Aristotle");
		
	}

}
