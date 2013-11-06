package com.spring.sample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.sample.dao.ClientDAO;
import com.spring.sample.model.Client;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
		
		ClientDAO dao = (ClientDAO) context.getBean("clientDAO");
		
		List<Client> list = dao.findAll();
		
		System.out.println(list.size());
	}

}
