package com.spring.sample.training.qualifier;

import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {

	public String getName() {
		return "Ice Cream";
	}

}
