package com.spring.sample.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.User;
import com.spring.sample.model.json.JsonLogin;
import com.spring.sample.util.Utils;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserDAO userDAO;


	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(HttpServletRequest request, ModelMap model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			if (user.isAdmin()) {
				return "redirect:/admin";
			} else {
				return "redirect:/user/myaccount";
			}

		}
		return "user/signin";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createaccount(HttpServletRequest request, ModelMap model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			if (user.isAdmin()) {
				return "redirect:/admin";
			} else {
				return "redirect:/user/myaccount";
			}

		}

		model.put("user", new User());
		return "user/createAccount";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(HttpServletRequest request,
			@ModelAttribute("user") User user) {

		User oldUser = userDAO.findByUserName(user.getUserName());

		JsonLogin login = new JsonLogin();
		if (oldUser == null) {
			user.setEmail(user.getUserName());
			user.setPassword(Utils.getHashMD5(user.getPassword()));
			boolean isSaved = userDAO.save(user);
			if (isSaved == false) {
				login.setErrorMessage("There's an internal server error");
			} else {
				user = userDAO.findByUserName(user.getUserName());
				request.getSession().setAttribute("user", user);
			}
			login.setSuccess(isSaved);

		} else {
			login.setErrorMessage("The email already existed. Please choose another email.");
			login.setSuccess(false);
		}

		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").deepSerialize(login), HttpStatus.OK);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, ModelMap model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/signin";

		}

		model.put("user", user);
		return "user/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseEntity<String> editProfile(
			@ModelAttribute("user") User user,
			@RequestPart("fileData") MultipartFile multipartfile,
			HttpServletRequest request) {


		String filePath = request.getSession().getServletContext()
				.getRealPath("/images/");
		if (multipartfile != null) {
			
			File file = null;
			try {
				file = new File(filePath);
				multipartfile.transferTo(file);

			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			user.setImageUrl("/images/" + multipartfile.getName());
		}

		boolean success = userDAO.update(user);

		JsonLogin login = new JsonLogin();

		// re-update current user on session if the user updated.
		if (success) {
			User currentUser = (User) request.getSession().getAttribute("user");
			if (currentUser != null
					&& user.getUserName().equals(currentUser.getUserName())) {
				request.getSession().setAttribute("user", user);
			}

			login.setRedirectUrl("/user/myaccount");
		} else {
			login.setErrorMessage("There's an internal server error");
		}

		login.setSuccess(success);

		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").deepSerialize(login), HttpStatus.OK);
	}

	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String myaccount(HttpServletRequest request, ModelMap model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/user/signin";

		}
		model.put("user", user);
		return "user/myAccount";
	}

}
