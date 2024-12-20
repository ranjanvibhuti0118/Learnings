package com.app.order.events;

import java.util.List;
import java.util.Map;

public class OrderCreatedEvent{
	
	private Long orderId;
	private Map<Long,Integer> productQtyMap;
	
	public Map<Long, Integer> getProductQtyMap() {
		return productQtyMap;
	}
	public void setProductQtyMap(Map<Long, Integer> productQtyMap) {
		this.productQtyMap = productQtyMap;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public OrderCreatedEvent(Long orderId, Map<Long, Integer> productQtyMap) {
		super();
		this.orderId = orderId;
		this.productQtyMap = productQtyMap;
	}
	public OrderCreatedEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderCreatedEvent [orderId=" + orderId + ", productQtyMap=" + productQtyMap + "]";
	}


	
}
