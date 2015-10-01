package com.spring.sample.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExcpetionHandler {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "error/404.html";
	}
}
