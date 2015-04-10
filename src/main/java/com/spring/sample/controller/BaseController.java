package com.spring.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.sample.dao.CategoryDAO;
import com.spring.sample.model.Category;

@Controller
public class BaseController {
	
	@Autowired
	protected CategoryDAO categoryDAO;
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
	   return categoryDAO.findAll(0, 0);
	}
	
	@ModelAttribute("currentCategory")
	public String currentCategory(HttpServletRequest request) {
		return "empty";
	}
		
}
