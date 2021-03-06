package com.spring.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.OrdersDAO;
import com.spring.sample.dao.ProductDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.Orders;
import com.spring.sample.model.Product;
import com.spring.sample.model.User;
import com.spring.sample.model.json.JsonLogin;
import com.spring.sample.util.Utils;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(HttpServletRequest request, ModelMap model) {

		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			
			if (user.isAdmin()) {
				return "redirect:/admin/product";
			} else {
				return "redirect:/user/myaccount";
			}

		}
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);
		
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
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);

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
			@ModelAttribute("user") User user, HttpServletRequest request) {


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
		
		List<Product> dealoftheday = productDAO.findDealofTheDay();
		
		model.addAttribute("products", dealoftheday);
		
		model.put("user", user);
		return "user/myAccount";
	}
	
	@RequestMapping(value="/myorders", method = RequestMethod.GET)
	public String myorders(HttpServletRequest request, ModelMap model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/signin";
		} else {
			List<Orders> orders = ordersDAO.findOrdersByUser(user);
			
			boolean emptyOrder = true;
			for (Orders order : orders) {
				for (Product p : order.getProducts()) {
					if (p != null && p.getId() > 0) {
						emptyOrder = false;
					}
				}
			}
			
			model.put("emptyOrder", emptyOrder);
			model.put("orders", orders);
		}
	
		return "user/myorders";
	}

}
