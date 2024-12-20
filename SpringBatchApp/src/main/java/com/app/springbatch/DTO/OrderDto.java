package com.app.springbatch.DTO;

public class OrderDto {

	private String orderStatus;
	private Long orderId;
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderDto(String orderStatus) {
		super();
		this.orderStatus = orderStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(String orderStatus, Long orderId) {
		super();
		this.orderStatus = orderStatus;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderDto [orderStatus=" + orderStatus + ", orderId=" + orderId + "]";
	}

	

}
