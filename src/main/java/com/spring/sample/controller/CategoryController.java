package com.spring.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.CategoryDAO;
import com.spring.sample.model.Category;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public String getProductsByCategory(@PathVariable int categoryId,
			ModelMap model) {

		Category category = categoryDAO.findById(categoryId);
		model.put("category", category);
		model.put("currentCategory", category.getName());
		
		return "category/productlisting";
	}

}
