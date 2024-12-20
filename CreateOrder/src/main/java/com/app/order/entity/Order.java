package com.app.order.entity;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name = "SalesOrder")
@DynamicUpdate
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@ManyToOne
	private Customer customer;

	@ManyToMany
	private List<Product> products;

	private String orderDate;
	private String orderStatus;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order(Long orderId, Customer customer, List<Product> products, String orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.products = products;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", products=" + products + ", orderDate="
				+ orderDate + ", orderStatus=" + orderStatus + "]";
	}


}
