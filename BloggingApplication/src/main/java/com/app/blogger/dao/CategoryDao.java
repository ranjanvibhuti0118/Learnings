package com.app.blogger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogger.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{
	
	Category findByCategoryDescription(String description);

}
