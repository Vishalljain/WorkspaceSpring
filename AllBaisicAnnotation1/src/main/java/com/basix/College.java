package com.basix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class College {
	
	@Autowired
	public Principle principle;
	
	@Autowired
	@Qualifier("scienceTeacher")
	public Teacher myTeacher;

	public void test() {
		principle.principalInfo();
		myTeacher.teacherName();
		System.out.println("Testing the call method using @Component");
		
	}
//	Error creating bean with name 'college': Unsatisfied dependency expressed through field 'myTeacher';
//	nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
//	No qualifying bean of type 'com.basix.Teacher' 
//	available: expected single matching bean but found 2: mathTeacher,scienceTeacher
	//so used @Primary

}
