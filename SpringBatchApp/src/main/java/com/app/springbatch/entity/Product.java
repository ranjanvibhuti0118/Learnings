package com.app.springbatch.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(length = 50,nullable = false)
	private String productName;
	@Column(length = 50,nullable = false)
	private String description;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Inventory> inventory= new ArrayList<>();

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, String productName, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", inventory=" + inventory + "]";
	}



}