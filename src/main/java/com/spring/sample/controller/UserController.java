package com.spring.sample.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserDAO userDAO;
	
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String signin(HttpServletRequest request, ModelMap model) {
		
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			if (user.isAdmin()) {
				return "forward:/admin";
			} else {
				return "forward:/user/myaccount";
			}
			
		}
		return "user/signin";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createaccount(HttpServletRequest request, ModelMap model) {
		return "user/createAccount";
	}	
	
	@RequestMapping(value="/myaccount", method = RequestMethod.GET)
	public String myaccount(ModelMap model) {
		return "user/myAccount";
	}	
	
	
	
}
