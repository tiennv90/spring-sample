package com.spring.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.ProductDAO;
import com.spring.sample.model.Product;


@Controller
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/special", method = RequestMethod.GET)
	public String specialProduct() {
		return "product/special";
	}

	@RequestMapping(value = "/dealoftheday", method = RequestMethod.GET)
	public String dealOfTheDay(Model model) {
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);
		
		return "product/dealoftheday";
	}


}
