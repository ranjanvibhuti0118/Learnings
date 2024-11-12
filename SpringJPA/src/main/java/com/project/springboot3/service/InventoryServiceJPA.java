package com.project.springboot3.service;

import java.util.List;

import com.project.springboot3.entity.Inventory;
import com.project.springboot3.view.InventoryView;
import com.project.springboot3.view.View;

public interface InventoryServiceJPA {

	public List<Inventory> findAllInventory(Integer inv);
	List<Inventory> findAllInventorySorted(Iterable<Integer> invId);
	void deleteById(List<Integer> invId);	
	
	//Static Projection
	List<InventoryView> fetchInventoryByItem(String itemId);
	
	//Dynamic Projection
	<T extends View> List<T> fetchInventoryByItemDynamic(String itemId, Class<T> cls);
	
	public Inventory getInventoryById(int i);

	public int deleteMyInventoryById(int id);
	
	public int createInventory(int id,String node,int quantity, String itemId);
}
