package com.spring.sample.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "id")	
	private int id;
	private Date date;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_product", 
		joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private List<Product> products;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "payment", cascade = CascadeType.ALL)
	private PaymentMethod payment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public PaymentMethod getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}

}
