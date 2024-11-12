package com.project.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.springboot3.service.InventoryServiceJPA;
import com.project.springboot3.view.InvView1;
import com.project.springboot3.view.InventoryView;

@SpringBootApplication
public class SpringJpaApplication2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJpaApplication2.class, args);


		InventoryServiceJPA service3 = container.getBean(InventoryServiceJPA.class);
	
		//Static Projection where we are fetching data based on static Interface
//		service3.fetchInventoryByItem("Pen").stream().forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getNode()));

		//Dynamic Projection
//		service3.fetchInventoryByItemDynamic("Pen", InvView1.class).forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getQuantity()));

		//Hibernate Query Language
//		System.out.println(service3.getInventoryById(3));
		System.out.println(service3.deleteMyInventoryById(5));
		//Native SQL Query
		System.out.println(service3.createInventory(88, "Muzaffarpur", 1,"Laptop"));
	}

}
