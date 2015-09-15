package com.spring.sample.training.nonautowired;

public class Student {
	
	private String name;
	private Subject subject;
	
	public Student(Subject subject, String name) {
		this.name = name;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
