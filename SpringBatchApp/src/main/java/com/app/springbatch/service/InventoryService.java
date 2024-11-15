package com.app.springbatch.service;

import com.app.springbatch.entity.Inventory;

public interface InventoryService {

	public Inventory findInventory(String productId, String qty);
	public Inventory updateInventory(Inventory inv);
}
