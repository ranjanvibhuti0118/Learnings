package com.project.springboot3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.springboot3.entity.Inventory;
import com.project.springboot3.view.InventoryView;
import com.project.springboot3.view.View;

import jakarta.transaction.Transactional;

public interface InventoryRepoWithJPA extends JpaRepository<Inventory, Integer>{

	public List<InventoryView> findByitemId(String itemId);
	
	//Syntax for pre-defined methods findBy+VariableName+Keywords like (lessThan/MoreThan etc)
	<T extends View> List<T> findByitemId(String itemId, Class<T> cls);

	@Query("FROM Inventory WHERE inventoryId=:inventoryId")
	public Inventory fetchInventoryById(@Param("inventoryId") int id);
	
	//For Non Select Operation using HQL, we have to use @Transactional and @Modifying annotation
	@Transactional
	@Modifying
	@Query("delete FROM Inventory WHERE inventoryId=:inventoryId")
	public int removeInventoryById(@Param("inventoryId") int id);
	
	@Transactional
	@Modifying
	@Query(value="insert into Inventory(`inventory_id`,`node`,`quantity`,`item_id`) values (?,?,?,?)",nativeQuery=true)
	public int insetIntoInvetory(int id,String node,int quantity,String itemId);
}
