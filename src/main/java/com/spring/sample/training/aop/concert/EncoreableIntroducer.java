package com.spring.sample.training.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
	
	@DeclareParents(value="com.spring.sample.training.aop.concert.Performance+", defaultImpl=DefaultEncoreable.class)
	public static Encoreable encoreable;
	
	 //If accessing a bean programmatically you 
	 //would write the following:
	
	 //Encoreable encoreable = (Encoreable) context.getBean("myPerformance");
}
