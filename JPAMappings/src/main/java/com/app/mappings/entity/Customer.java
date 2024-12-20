package com.app.mappings.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private Long custId;
	
	@OneToMany(mappedBy ="customer")
	private List<SalesOrder> order;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public List<SalesOrder> getOrder() {
		return order;
	}

	public void setOrder(List<SalesOrder> order) {
		this.order = order;
	}

	public Customer(Long custId, List<SalesOrder> order) {
		super();
		this.custId = custId;
		this.order = order;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", order=" + order + "]";
	}
	
	
}