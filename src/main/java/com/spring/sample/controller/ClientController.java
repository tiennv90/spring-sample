package com.spring.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.dao.ClientDAO;
import com.spring.sample.model.Client;
import com.spring.sample.model.json.JSONClient;
import com.spring.sample.model.json.JSONClients;
import com.spring.sample.model.json.JSONContactsLink;

import flexjson.JSONSerializer;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String>  getAllClients(HttpServletRequest request) {
		
		int startIndex = request.getParameter( "startIndex" ) != null ? Integer.valueOf( request.getParameter( "startIndex" ) ) : 0;
		int count = request.getParameter("count") != null ? Integer.valueOf( request.getParameter( "count" ) ) : 0;
		
		List<Client> clients = clientDAO.findAll(startIndex, count);
		
		JSONClients jsonClients = new JSONClients(clients);
		
		String restOfTheUrl = request.getRequestURL().toString();
		
		jsonClients.setTotalCount(clients != null ? clients.size() : 0);
		jsonClients.setHref(restOfTheUrl);
		
		return new ResponseEntity<String>(new JSONSerializer().exclude("*.class").deepSerialize(jsonClients), HttpStatus.OK) ;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getClient(@PathVariable("id") int id, HttpServletRequest request) {
		
		Client client = clientDAO.findById(id);
		
		String result = "";
		if (client != null) {
			
			JSONClient jsonClient = new JSONClient(client);
			JSONContactsLink link = new JSONContactsLink(request.getRequestURL().toString());
			
			jsonClient.setContactsLink(link);
			
			result = new JSONSerializer().exclude("*.class").deepSerialize(jsonClient);
		}
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@ModelAttribute("client") Client client, HttpServletRequest request) {
		clientDAO.update(client);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/contacts")
	public ResponseEntity<String> getContacts(HttpServletRequest request) {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
