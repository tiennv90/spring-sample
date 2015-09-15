package com.spring.sample.training.nonautowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	public Student student() {
		return new Student(new JavaProgrammingCourse(), "Student A");
	}
}