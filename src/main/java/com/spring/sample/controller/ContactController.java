package com.spring.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.ProductDAO;
import com.spring.sample.model.Feedback;
import com.spring.sample.model.Product;

@Controller
@RequestMapping(value="/contact")
public class ContactController extends BaseController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);
		
		model.addAttribute("feedback", new Feedback());
		
		return "contact";
	}
}
