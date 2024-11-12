package com.app.blogger.exception;

public class PostNotTransferableException extends RuntimeException {

	public PostNotTransferableException(Long errorMessage) {

		super("Post with postId " + errorMessage +" is not transferable to new user");
	}
}
