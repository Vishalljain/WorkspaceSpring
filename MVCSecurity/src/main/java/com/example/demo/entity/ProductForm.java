package com.example.demo.entity;

public class ProductForm {

    private String name;
    private double cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ProductForm(String name, double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	public ProductForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}

