package com.spring.sample.training.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("execution (public String com.spring.sample.training.aop.model.Shape.getName())")
	public void loggingAdvice() {
		System.out.println("Advice run. Get method called");
	}
	
	@Before("allGetters()")
	public void loggingGlobalAdvice() {
		System.out.println("Global Advice run. Get method called (point cut)");
	}
	
	@Before("allGetters() && allShapeMethods()")
	public void loggingSecondAdvice() {
		System.out.println("Second advice executed (point cut - combine point cut example)");
	}
	
	@Before("allShapeMethods()")
	public void loggingShapeMethods() {
		System.out.println("All shape methods executed (point cut)");
	}
	
	@Pointcut("execution ( * get*())")
	public void allGetters() {}
	
	@Pointcut("execution (* com.spring.sample.training.aop.model.Shape.*(..))")
	public void allShapeMethods() {}
	
	@Pointcut("within(com.spring.sample.training.aop.model.Shape+)")
	public void allShapeMethods2() {}
}
