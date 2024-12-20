package com.app.mappings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "SalesOrder")
public class SalesOrder {
	@Id
	private Long id;
	
	@ManyToOne
	private Customer customer;

	public SalesOrder(Long id, Customer customer) {
		super();
		this.id = id;
		this.customer = customer;
	}

	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + "]";
	}

	
}
