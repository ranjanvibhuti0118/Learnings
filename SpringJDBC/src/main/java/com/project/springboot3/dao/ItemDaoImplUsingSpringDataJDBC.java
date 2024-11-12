package com.project.springboot3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.springboot3.entity.Item;

@Repository
public class ItemDaoImplUsingSpringDataJDBC implements ItemDAO{

	private static final String QUERY = "insert into Item values(?,?,?,?)";
	@Autowired
	private JdbcTemplate template;
	
	
	@Override
	public List<Item> getItemsList() {
		
		return null;
	}
	
	public void addProducts(Item item) {
		
		template.update(QUERY, item.getId(),item.getName(),item.getDescription(),item.getSize());
		
	}

}
