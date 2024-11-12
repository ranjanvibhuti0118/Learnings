package com.app.blogger.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogger.entity.Category;
import com.app.blogger.service.CategoryService;

@RestController
public class CategoryController {	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create/category")
	public Category createCategory(@RequestBody Category categoryDTO) {

		Category savedCategory= categoryService.saveCategory(categoryDTO);

		return savedCategory;	
	}
	
	@GetMapping("/categories")
	public Set<Category> getCategory(@RequestBody Category categoryDTO) {

		 Set<Category> allCategory = categoryService.getCategories();

		return allCategory;	
	}
}