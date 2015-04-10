package com.spring.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.FeedbackDAO;
import com.spring.sample.model.Feedback;

@Controller
@RequestMapping(value="/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		
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
