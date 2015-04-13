package com.spring.sample.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.dao.OrdersDAO;
import com.spring.sample.model.Orders;
import com.spring.sample.model.Product;


@Controller
@RequestMapping(value="/orders")
public class OrdersController {
	
	@Autowired
	private OrdersDAO ordersDAO;
	
	protected static Logger logger = Logger.getLogger("OrdersController");
	
	@RequestMapping(value="/remove", method=RequestMethod.GET) 
	private String remove(@RequestParam("orderId") Integer orderId ) {
		
		ordersDAO.remove(orderId);
		
		return "redirect:/user/myorders";
		
	}
	
	@RequestMapping(value="/{orderid}/removeproduct", method=RequestMethod.GET)
	private String removeProduct(@PathVariable("orderid") Integer orderId, @RequestParam("productId") Integer  productId) {
		
		Orders order = ordersDAO.findbyId(orderId);
		if (order != null) {
			
			
			List<Product> productsToRemove = new ArrayList<Product>();
			for (Product p : order.getProducts()) {
				if (p.getId() == productId) {
					
					productsToRemove.add(p);
				}
			}
			
			List<Product> products = order.getProducts();
			products.removeAll(productsToRemove);
			
			order.setProducts(products);
			
			ordersDAO.update(order);
		}
		
		return "redirect:/user/myorders";
		
	}
	
	
}
