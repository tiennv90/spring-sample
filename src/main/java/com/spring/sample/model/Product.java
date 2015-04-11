package com.spring.sample.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	private String name;
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	private String imageUrl;
	private Double discountPrice;
	private boolean isSpecialProduct;
	private boolean dealOfTheDay;
	
	@OneToMany
	@JoinColumn(name="userId")
	private List<Orders> orders;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isSpecialProduct() {
		return isSpecialProduct;
	}

	public void setSpecialProduct(boolean isSpecialProduct) {
		this.isSpecialProduct = isSpecialProduct;
	}

	public boolean isDealOfTheDay() {
		return dealOfTheDay;
	}

	public void setDealOfTheDay(boolean dealOfTheDay) {
		this.dealOfTheDay = dealOfTheDay;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
}
