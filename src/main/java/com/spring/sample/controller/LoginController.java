package com.spring.sample.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> index(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password) {
		
		password = getHashMD5(password);
		User user = userDAO.findByUserNameAndPassword(userName, password);
		JsonLogin jsonLogin = new JsonLogin();
		if (user != null) {
			jsonLogin.setSuccess(true);
			if (user.isAdmin()) {
				
				jsonLogin.setRedirectUrl("/admin");
			} else {
				
				jsonLogin.setRedirectUrl("/");
			}
			
			request.getSession().setAttribute("user", user);
		} else {
			jsonLogin.setErrorMessage("User name or password do not match");
		}
		return new ResponseEntity<String>(new JSONSerializer().exclude("*.class").deepSerialize(jsonLogin), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}
	
	static private String getHashMD5(String string) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        BigInteger bi = new BigInteger(1, md.digest(string.getBytes()));
	        return bi.toString(16);
	    } catch (NoSuchAlgorithmException ex) {
	       
	    	ex.printStackTrace();

	        return "";
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(getHashMD5("tien"));
	}
	
}
