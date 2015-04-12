package com.spring.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.User;
import com.spring.sample.model.json.JsonLogin;
import com.spring.sample.util.Utils;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> index(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password) {
		
		password = Utils.getHashMD5(password);
		User user = userDAO.findByUserNameAndPassword(userName, password);
		JsonLogin jsonLogin = new JsonLogin();
		if (user != null) {
			jsonLogin.setSuccess(true);
			if (user.isAdmin()) {
				
				jsonLogin.setRedirectUrl("/admin/product");
			} else {
				
				jsonLogin.setRedirectUrl("/");
			}
			
			request.getSession().setAttribute("user", user);
		} else {
			jsonLogin.setSuccess(false);
			jsonLogin.setErrorMessage("User name or password does not match");
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude("*.class").deepSerialize(jsonLogin), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}
	
	
	
}
