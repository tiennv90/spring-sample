package com.spring.sample.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.dao.OrdersDAO;
import com.spring.sample.dao.ProductDAO;
import com.spring.sample.model.Orders;
import com.spring.sample.model.Product;
import com.spring.sample.model.User;
import com.spring.sample.util.Utils;

@Controller
@RequestMapping(value="/cart")
public class CartController extends BaseController {
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping
	public String index(HttpServletRequest request, Model model) {	
		
		Orders order = (Orders) request.getSession().getAttribute("currentOrders");
		if (order != null && order.getProducts().size() > 0) {
			
			double total = 0;
			
			for (Product p : order.getProducts()) {
				total += p.getPrice();
			}
			
			model.addAttribute("orders", order);
			model.addAttribute("total", Utils.round(total, 2));
		} else {
			model.addAttribute("emptyCartMessage", "Cart is empty");
		}
		
		return "cart";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addToCart(@RequestParam("productId") int productId, HttpServletRequest request, Model model) {
		
		Product product = productDAO.findById(productId);
		
		if (product != null) {
			Orders orders = (Orders) request.getSession().getAttribute("currentOrders");
			
			if (orders == null) {
				orders = new Orders();
			}
			
			orders.getProducts().add(product);
			
			request.getSession().setAttribute("currentOrders", orders);
		}
		
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String removeFromCart(@RequestParam("productId") int productId, HttpServletRequest request, Model model) {
		
		Orders orders = (Orders) request.getSession().getAttribute("currentOrders");
		
		if (orders != null) {
			
			List<Product> listToRemove = new ArrayList<Product>();
			
			for (Product p : orders.getProducts()) {
				if (p.getId() == productId) {
					listToRemove.add(p);
				}
			}
			
			orders.getProducts().removeAll(listToRemove);
			
			request.getSession().setAttribute("currentOrders", orders);
			
		}
			
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/checkoutprocess", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(HttpServletRequest request,
			@RequestParam("cardnumber") String cardNumber, @RequestParam("cvvnumber") String cvv,
			@RequestParam("cardexpiresMonth") String cardexpiresMonth, @RequestParam("cardexpiresYear") String cardexpiresYear) {
		
		Orders orders = (Orders) request.getSession().getAttribute("currentOrders");
		User currentUser = (User) request.getSession().getAttribute("user");

		String result = "{success : false}";
		if (orders != null && currentUser != null) {
			
			orders.setCardNumber(cardNumber);
			orders.setCvv(cvv);
			orders.setOrderDate(new Date()); 
			orders.setUser(currentUser);
			orders.setCardexpiresMonth(cardexpiresMonth);
			orders.setCardexpiresYear(cardexpiresYear);
			
			boolean isSaved = ordersDAO.save(orders);
			result = "{success :" + isSaved + "}";
			
			request.getSession().removeAttribute("currentOrders");
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}
