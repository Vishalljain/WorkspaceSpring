package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "student_course",
	               joinColumns = @JoinColumn(name = "student_id"),
	               inverseJoinColumns = @JoinColumn(name = "course_id"))
	    private List<Course> courses = new ArrayList<>();
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Course> getCourses() {
			return courses;
		}
		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		public Student(Long id, String name, List<Course> courses) {
			super();
			this.id = id;
			this.name = name;
			this.courses = courses;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
	

}
