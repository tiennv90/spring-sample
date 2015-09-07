package com.spring.sample.training.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution (public String com.spring.sample.training.aop.model.Shape.getName())")
	public void loggingAdvice() {
		System.out.println("Advice run. Get method called");
	}
	
	@Before("execution (public * get*())")
	public void loggingGlobalAdvice() {
		System.out.println("Global Advice run. Get method called");
	}
	
	@Before("execution ( * get*())")
	public void loggingSecondAdvice() {
		System.out.println("Second advice executed");
	}
}
