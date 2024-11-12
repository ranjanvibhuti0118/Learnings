package com.project.springboot3.service;

import com.project.springboot3.entity.Inventory;

public interface InventoryServiceCRUD {

 Inventory updateStock(Inventory inv);	
 Iterable<Inventory> findInventroyForNode(String node);
 Iterable<Inventory> bulkUpdateStock(Iterable<Inventory> listInv);
 void deleteInventory(Inventory inv);
 
 
}
