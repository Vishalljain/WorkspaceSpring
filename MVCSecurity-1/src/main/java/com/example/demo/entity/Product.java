package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    private String username; // Added field to store the username
    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String name, double cost, String username) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.username = username;
	}
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

    // Getters and setters (omitted for brevity)
}

