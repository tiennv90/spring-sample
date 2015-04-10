package com.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/contact")
public class ContactController extends BaseController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "contact";
	}
}
