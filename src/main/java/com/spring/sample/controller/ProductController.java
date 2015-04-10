package com.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/product")
public class ProductController {

	
	@RequestMapping(value="/special", method = RequestMethod.GET)
	public String specialProduct() {
		return "product/special";
	}

	@RequestMapping(value="/dealoftheday", method = RequestMethod.GET)
	public String dealOfTheDay() {
		return "product/dealoftheday";
	}
	
}
