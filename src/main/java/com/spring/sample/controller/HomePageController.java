package com.spring.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.model.Category;

@Controller
public class HomePageController extends BaseController {
	
	@RequestMapping("/")
	public String homepage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		List<Category> top5Categories = categoryDAO.findAll(0, 5);
		model.addAttribute("top5Categories", top5Categories);
	    return "homepage/index";
	}

	@Override
	public String currentCategory() {
		return "empty";
	}

}
