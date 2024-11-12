package com.app.blogger.service;

import java.util.Set;

import com.app.blogger.entity.Category;
import com.app.blogger.entity.Post;

public interface CategoryService {

	Category saveCategory(Category cat);
	Set<Post> getPostsForCategory(Long categoryId);
	Category findCategoryByDescription(String description);
	Set<Category> getCategories();
	
}
