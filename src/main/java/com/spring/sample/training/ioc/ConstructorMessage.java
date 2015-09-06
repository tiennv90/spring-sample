package com.spring.sample.training.ioc;

public class ConstructorMessage {
	
	private String message;
	
	public ConstructorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
