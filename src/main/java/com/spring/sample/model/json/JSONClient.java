package com.spring.sample.model.json;

import com.spring.sample.model.Client;

public class JSONClient {

	private String href;
	private int id;
	private String salesForceId;
	private int jiveId;
	private String practice;
	private String potential;
	private String stage;
	private String pace;
	private JSONContactsLink contactsLink;

	public JSONClient(Client client) {
		this.id = client.getId();
		this.salesForceId = client.getSalesForceId();
		this.jiveId = client.getJiveId();
		this.practice = client.getPractice();
		this.potential = client.getPotential();
		this.stage = client.getStage();
		this.pace = client.getPace();
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesForceId() {
		return salesForceId;
	}

	public void setSalesForceId(String salesForceId) {
		this.salesForceId = salesForceId;
	}

	public int getJiveId() {
		return jiveId;
	}

	public void setJiveId(int jiveId) {
		this.jiveId = jiveId;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getPotential() {
		return potential;
	}

	public void setPotential(String potential) {
		this.potential = potential;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getPace() {
		return pace;
	}

	public void setPace(String pace) {
		this.pace = pace;
	}

	public JSONContactsLink getContactsLink() {
		return contactsLink;
	}

	public void setContactsLink(JSONContactsLink contactsLink) {
		this.contactsLink = contactsLink;
	}
}
