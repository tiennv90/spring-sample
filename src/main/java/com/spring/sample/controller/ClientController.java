package com.spring.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.sample.dao.ClientDAO;
import com.spring.sample.model.Client;
import com.spring.sample.model.json.JSONClient;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getAllClient(HttpServletRequest request) {
		
		List<Client> clients = clientDAO.findAll();
		
		JSONClient jsonClients = new JSONClient(clients);
		
		String restOfTheUrl = request.getRequestURL().toString();
		jsonClients.setTotalCount(clients != null ? clients.size() : 0);
		jsonClients.setHref(restOfTheUrl);
		
		return new JSONSerializer().exclude("*.class").deepSerialize(jsonClients);
	}

}
