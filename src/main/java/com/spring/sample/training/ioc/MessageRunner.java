package com.spring.sample.training.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunner {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("defaultMessageTest-context.xml");
		System.out.println("Spring context initialized.");
		
		DefaultMessage defaultMessage = (DefaultMessage) applicationContext.getBean("message");
		
		System.out.println(defaultMessage.getMessage());
		
		DefaultMessage message2 = (DefaultMessage) applicationContext.getBean("message2");
		
		System.out.println(message2.getMessage());
		
		ConstructorMessage constructorMessage = 
				(ConstructorMessage) applicationContext.getBean("constructorMessage");
		
		System.out.println(constructorMessage.getMessage());
	}

}
