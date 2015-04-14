package com.spring.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.FeedbackDAO;
import com.spring.sample.dao.ProductDAO;
import com.spring.sample.model.Feedback;
import com.spring.sample.model.Product;

@Controller
@RequestMapping(value="/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);
		
		model.put("feedback", new Feedback());
		
		return "feedback";
		
	}	

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
		
		boolean isSaved = feedbackDAO.save(feedback);
		
		String result =  (isSaved == true ? "successfully" : "unsuccessfully");
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
