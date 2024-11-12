package com.project.springboot3;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.springboot3.dao.ItemDAOImplUsingJDBCApi;
import com.project.springboot3.dao.ItemDaoImplUsingSpringDataJDBC;
import com.project.springboot3.entity.Item;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJdbcApplication.class, args);
		
		//Spring Data JDBC
		/*
		 * This complete logic is shifted to class implementing command line runner, on back of run method
		 * 
		 * 
		 * ItemDaoImplUsingSpringDataJDBC itemDAOImplSpringDataJDBC =
		 * container.getBean(ItemDaoImplUsingSpringDataJDBC.class);
		 * itemDAOImplSpringDataJDBC.addProducts(new
		 * Item("10","Boroplus","Imami Skin Cream","S"));
		 */
		
		
		//JDBC API Example
		ItemDAOImplUsingJDBCApi itemDAOImplJDBCApi = container.getBean(ItemDAOImplUsingJDBCApi.class);
		List<Item> itemList = itemDAOImplJDBCApi.getItemsList();
		itemList.stream().forEach(item->{System.out.println(item);});
		
	}

}
