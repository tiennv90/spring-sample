package com.spring.sample.model.json;

import java.util.ArrayList;
import java.util.List;

import com.spring.sample.model.Client;

public class JSONClients {

	private String href;
	private List<Client> clients = new ArrayList<Client>();
	private String next;
	private String previous;
	private int totalCount;

	public JSONClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
