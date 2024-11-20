package com.app.consumer.entity;

public class Consumer {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Consumer(String message) {
		super();
		this.message = message;
	}

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Consumer [message=" + message + "]";
	}
	
}
