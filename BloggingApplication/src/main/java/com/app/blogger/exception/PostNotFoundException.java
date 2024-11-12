package com.app.blogger.exception;

public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException(Long postId) {
		
		super("Post with postId "+postId +" do not exist.");
	}
}
