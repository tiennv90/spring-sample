package com.spring.sample.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.FeedbackDAO;
import com.spring.sample.dao.ProductDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.Feedback;
import com.spring.sample.model.Product;
import com.spring.sample.model.User;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public String feedback(HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<Feedback> list = feedbackDAO.findAll(0, 0);
			
			model.addAttribute("feedbacks", list);
			model.addAttribute("active", "feedback");
			
			return "admin/feedback";

		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String product(HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<Product> list = productDAO.findAll(0, 0);
			
			model.addAttribute("products", list);
			model.addAttribute("active", "product");
			
			return "admin/product/view";

		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String user(HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<User> users = userDAO.findAll(0, 0);
			
			List<User> listToRemove = new ArrayList<User>();
			for (User u : users) {
				if (u.getOrders() == null || u.getOrders().isEmpty()) {
					listToRemove.add(u);
				}
			}
			
			users.removeAll(listToRemove);
			
			model.addAttribute("active", "feedback");
			model.addAttribute("users", users);
			model.addAttribute("active", "user");
			
			return "admin/user";

		}
		
		return "redirect:/";
		
	}
	
}
