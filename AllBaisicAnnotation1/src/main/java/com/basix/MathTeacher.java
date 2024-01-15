package com.basix;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MathTeacher implements Teacher{

	@Override
	public void teacherName() {
		System.out.println("Math Teacher Aryabhatt");
		
	}

}
