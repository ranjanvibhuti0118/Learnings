package com.app.order.exception;

public class OrderProcessingException extends RuntimeException {

	public OrderProcessingException(String message){
		super(message);
	}
}
