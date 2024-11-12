package com.app.blogger.exception;

public class InternalServerException extends RuntimeException {

	public InternalServerException() {
		
		super("Something went wrong!");
	}
	
}
