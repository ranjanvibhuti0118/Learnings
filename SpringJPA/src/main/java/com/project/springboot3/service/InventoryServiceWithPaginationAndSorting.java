package com.project.springboot3.service;

import java.util.List;

import com.project.springboot3.entity.Inventory;

public interface InventoryServiceWithPaginationAndSorting {

	Iterable<Inventory> fetchDetails(boolean isAscOrDesc, String ...property);
	
	List<Inventory>fetchDetailsWithPageableObj(int pageSize,int pageNo);
}
