package com.spring.sample.training.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.sample.training.aop.model.Shape;
import com.spring.sample.training.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspectj-example-config.xml");
		ShapeService shapeService = (ShapeService) applicationContext.getBean("shapeService");
		
		Shape shape = shapeService.getShape();
		shape.setName("Dummy Name");
		System.out.println(shape.getName());
	}

}
