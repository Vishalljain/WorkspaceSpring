package com.studentmanagement.dto;

public class StudentDTO {//DTO means transfer data from frontend to backend so name is dto data transfre object
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name="vishal";
	private Long mobile=63662L;
	private String country="INDIA";
	public StudentDTO() {
		super();
		
	}
	public StudentDTO(String name, long mobile, String country) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
	}
	
	


}
