package com.app.blogger.exception;

public class CategoryNotFoundException extends RuntimeException {


	public CategoryNotFoundException(Long categoryId) {
		
		super("Category with id "+categoryId +" do not exist.");
	}
}
