package com.app.blogger.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.blogger.dao.CategoryDao;
import com.app.blogger.entity.Category;
import com.app.blogger.entity.Post;
import com.app.blogger.exception.InternalServerException;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	
	private CategoryDao categoryDao;

	
	CategoryServiceImpl(CategoryDao categoryDao)
	{
		this.categoryDao= categoryDao;
	}


	@Override
	public Set<Post> getPostsForCategory(Long categoryId) {

		Set<Post> postList= new HashSet<>();
		Optional<Category> category = categoryDao.findById(categoryId);
		if(category.isPresent()) {
			Category cat= category.get();
			
			postList=cat.getAllPostByCategory();
			
		}
		return postList;
	}


	@Override
	public Category findCategoryByDescription(String description) {
		return categoryDao.findByCategoryDescription(description);
	}


	@Override
	public Category saveCategory(Category cat) {
		Category savedCategory= categoryDao.save(cat);
		
		if(savedCategory==null) {
			throw new InternalServerException();
		}
		
		return savedCategory;
		
	}


	@Override
	public Set<Category> getCategories() {
		
		List<Category> allCategory=categoryDao.findAll();
		return allCategory.stream().collect(Collectors.toSet());
	}

	

}
