package com.app.springbatch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventroyId;
		
	@ManyToOne
	private Product product;
	
	private Integer qty;

	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getInventroyId() {
		return inventroyId;
	}

	public void setInventroyId(Long inventroyId) {
		this.inventroyId = inventroyId;
	}


	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Inventory(Long inventroyId, Product product, Integer qty) {
		super();
		this.inventroyId = inventroyId;
		this.product = product;
		this.qty = qty;
	}



	@Override
	public String toString() {
		return "Inventory [inventroyId=" + inventroyId + ", product=" + product + ", qty=" + qty + "]";
	}

	
	
}
