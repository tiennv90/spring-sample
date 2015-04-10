package com.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/about")
public class AboutUsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "about";
	}
}