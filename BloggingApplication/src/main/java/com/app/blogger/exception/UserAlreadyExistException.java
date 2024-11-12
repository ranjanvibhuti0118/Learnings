package com.app.blogger.exception;

public class UserAlreadyExistException extends RuntimeException{

	public UserAlreadyExistException(String errorMessage) {
		
		super(errorMessage);
	}
}
