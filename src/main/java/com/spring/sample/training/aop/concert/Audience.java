package com.spring.sample.training.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
	
	@Before("execution (** om.spring.sample.training.aop.concert.Performance.perform(..))")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}
	
	public void takeSeats() {
		System.out.println("taking seats");
	}
}
