package com.spring.sample.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspectJoinPointExample {
	
	@Before("allShapeMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println("Advice run.Get method called");
	}
	
	@Pointcut("execution ( * get*())")
	public void allGetters() {}
	
	@Pointcut("within(com.spring.sample.training.aop.model.Shape+)")
	public void allShapeMethods() {}
}
