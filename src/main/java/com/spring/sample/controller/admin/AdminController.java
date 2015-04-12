package com.spring.sample.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.dao.CategoryDAO;
import com.spring.sample.dao.FeedbackDAO;
import com.spring.sample.dao.ProductDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.Category;
import com.spring.sample.model.Feedback;
import com.spring.sample.model.Product;
import com.spring.sample.model.User;
import com.spring.sample.model.json.JsonLogin;
import com.spring.sample.util.Utils;

import flexjson.JSONSerializer;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value="/feedback", method = RequestMethod.GET)
	public String feedback(HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<Feedback> list = feedbackDAO.findAll(0, 0);
			
			model.addAttribute("feedbacks", list);
			
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
			
			return "admin/product/view";

		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/product/delete", method = RequestMethod.GET)
	public String removeProduct(@RequestParam("productId") Integer productId, HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
			productDAO.remove(productId);
			
		}
		
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value="/product/edit", method = RequestMethod.GET)
	public String editProduct(@RequestParam("productId") Integer productId, HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<Category> list = categoryDAO.findAll(0, 0);
			Product p = productDAO.findById(productId);
			
			model.addAttribute("categories", list);
			model.addAttribute("product", p);
			
			return "admin/product/edit";

		}
		
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value = "/product/addOrEdit", method = RequestMethod.POST)
	public ResponseEntity<String> addOrEdit(HttpServletRequest request,
			@ModelAttribute("product") Product product, @RequestParam("categoryId") Integer categoryId) {

		boolean isSaved = false;
		Category c = categoryDAO.findById(categoryId);
		if (c != null) {
			product.setCategory(c);
		}
		
		if (product.getId() <= 0) {
			isSaved = productDAO.save(product);
		} else {
			Product oldProduct = productDAO.findById(product.getId());
			oldProduct.setName(product.getName());
			oldProduct.setCategory(product.getCategory());
			oldProduct.setPrice(product.getPrice());
			
			if (product.getImageUrl() != null && !product.getImageUrl().isEmpty()) {
				oldProduct.setImageUrl(product.getImageUrl());
			}
			
			oldProduct.setDiscountPrice(product.getDiscountPrice());
			
			isSaved = productDAO.update(oldProduct);
		}

		isSaved = true;
		JsonLogin login = new JsonLogin();
		if (isSaved) {
			
			login.setSuccess(true);

		} else {
			login.setErrorMessage("The email already existed. Please choose another email.");
			login.setSuccess(false);
		}

		return new ResponseEntity<String>(new JSONSerializer().exclude(
				"*.class").deepSerialize(login), HttpStatus.OK);
	}
	
	@RequestMapping(value="/product/add", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request, Model model) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user != null && user.isAdmin()) {
			
				
			List<Category> list = categoryDAO.findAll(0, 0);
			
			model.addAttribute("categories", list);
			model.addAttribute("product", new Product());
			
			return "admin/product/edit";

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
			
			model.addAttribute("users", users);
			
			return "admin/user";

		}
		
		return "redirect:/";
		
	}
	
}
