package com.project.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.project.springboot3.entity.Inventory;
import com.project.springboot3.service.InventoryServiceCRUD;
import com.project.springboot3.service.InventoryServiceJPA;
import com.project.springboot3.service.InventoryServiceWithPaginationAndSorting;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJpaApplication.class, args);

		//Crud Repository Examples
//		InventoryServiceCRUD service1 = container.getBean(InventoryServiceCRUD.class);
//		System.out.println(service1.getClass());


		//		Inventory inv= new Inventory("PUNE",2,"Pen",LocalDateTime.now());
		//		Inventory invDb = service1.updateStock(inv);
		//		
		//		System.out.println(invDb.getInventoryId());
		//		System.out.println(service1.findInventroyForNode("PUNE"));




		//Pagination and Sorting Repository Examples

		InventoryServiceWithPaginationAndSorting service2 = container.getBean(InventoryServiceWithPaginationAndSorting.class);
		Iterable<Inventory> allInv = service2.fetchDetails(true, "itemId");

//				allInv.forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getNode()));
				service2.fetchDetailsWithPageableObj(3, 5).stream().forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getNode()));;

		InventoryServiceJPA service3 = container.getBean(InventoryServiceJPA.class);
		//		service3.findAllInventory(8).stream().forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getNode()));;
		//		
		//		List<Integer> Ids=new ArrayList<>();
		//		Ids.add(1);
		//	
		//		//Single DB hit with JPA DeleteById Method
		//		service3.deleteById(Ids);


//		service3.fetchInventoryByItem("Book").stream().forEach(inv->System.out.println(inv.getInventoryId()+":"+ inv.getNode()));


	}

}
