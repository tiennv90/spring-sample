package com.spring.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.dao.UserDAO;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserDAO userDAO;

//	@RequestMapping(method = RequestMethod.POST)
//	public String index(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password) {
//		return "";
//	}
	
}
