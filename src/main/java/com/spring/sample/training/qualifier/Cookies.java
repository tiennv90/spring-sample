package com.spring.sample.training.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cookies implements Dessert {

	public String getName() {
		return "Cookies";
	}

}
