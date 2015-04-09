package com.spring.sample.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "client")
public class Client {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String salesForceId;
	private int jiveId;
	private String practice;
	private String potential;
	private String stage;
	private String pace;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "salesforce_id")
	public String getSalesForceId() {
		return salesForceId;
	}
	public void setSalesForceId(String salesForceId) {
		this.salesForceId = salesForceId;
	}
	
	@Column(name = "jive_space_id")
	public int getJiveId() {
		return jiveId;
	}
	public void setJiveId(int jiveId) {
		this.jiveId = jiveId;
	}
	
	@Column(name = "practice")
	public String getPractice() {
		return practice;
	}
	public void setPractice(String practice) {
		this.practice = practice;
	}
	
	@Column(name = "potential")
	public String getPotential() {
		return potential;
	}
	public void setPotential(String potential) {
		this.potential = potential;
	}
	
	@Column(name = "stage")
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	@Column(name = "pace")
	public String getPace() {
		return pace;
	}
	public void setPace(String pace) {
		this.pace = pace;
	}
}
