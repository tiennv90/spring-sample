package com.spring.sample.training.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Cake implements Dessert {

	public String getName() {
		return "Cake";
	}

}
