package com.app.order.exception;

public class OrderNumberNotUniqueException extends RuntimeException {

	public OrderNumberNotUniqueException(String message) {
		super(message);
	}
	
}
