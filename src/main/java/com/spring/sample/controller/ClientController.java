package com.spring.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.sample.dao.ClientDAO;
import com.spring.sample.model.Client;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public @ResponseBody String getAllClient() {
		List<Client> clients = clientDAO.findAll();
		String json = new JSONSerializer().serialize(clients);
		return json;
	}

}
