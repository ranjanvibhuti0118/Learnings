package com.app.consumer.events;

import java.util.List;

public class OrderCreatedEvent{
	
	private Long orderId;
	private List<Long> productIds;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	public OrderCreatedEvent(Long orderId, List<Long> productIds) {
		super();
		this.orderId = orderId;
		this.productIds = productIds;
	}
	public OrderCreatedEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderCreatedEvent [orderId=" + orderId + ", productIds=" + productIds + "]";
	}

	
}
