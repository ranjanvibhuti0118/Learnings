package com.app.blogger.exception;

public class InvalidRequestException extends RuntimeException {
	public InvalidRequestException(String errorMessage){
		super(errorMessage);
	}

}
