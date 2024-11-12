package com.app.blogger.exception;

public class CommentNotFoundException extends RuntimeException {

	public CommentNotFoundException(String error){
		
		super("Comment with id "+ error +" not found");
	}
}
