package com.project.springboot3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.springboot3.dao.ItemDaoImplUsingSpringDataJDBC;
import com.project.springboot3.entity.Item;

@Component
public class JDBCRunner  implements CommandLineRunner{

	@Autowired
	ItemDaoImplUsingSpringDataJDBC repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		repo.addProducts(new Item("11","Iphone13","2024 Release","XL"));
	}

}
