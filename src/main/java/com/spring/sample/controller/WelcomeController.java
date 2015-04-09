package com.spring.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		model.addAttribute("message", "Spring 3 MVC Hello World Test Test");
		return "hello";
 
	}

	@RequestMapping( value = "/{file_id}")
	public String getModule( @PathVariable( "file_id" ) int fileId, ModelMap model )
	{
		model.addAttribute("message", "Hello this " + fileId);
		return "hello";
	}
}
