package com.spring.sample.training.aop.model;

public abstract class Shape {
	
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Setter function called");
		throw (new RuntimeException());
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("setNameAndReturn function called");
		return name;	
	}
}
