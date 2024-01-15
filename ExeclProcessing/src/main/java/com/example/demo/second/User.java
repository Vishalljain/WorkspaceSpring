package com.example.demo.second;

public class User {
	
	private String functionName;
	private String use;
	private String value;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String functionName, String use, String value) {
		super();
		this.functionName = functionName;
		this.use = use;
		this.value = value;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "User [functionName=" + functionName + ", use=" + use + ", value=" + value + "]";
	}

}
