package com.app.blogger.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long userId) {
		
		super("User with userId: "+userId+" do not exist");
	}
	
}
