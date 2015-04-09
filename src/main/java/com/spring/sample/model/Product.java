package com.spring.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	private String name;
	private int price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", nullable = false, insertable = false, updatable = false)
	private Category category;

	private String imageUrl;
	private int discountPrice;
	private boolean isSpecialProduct;
	private boolean dealOfTheDay;
	
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
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
	
	
}
