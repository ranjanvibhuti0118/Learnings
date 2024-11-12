package com.project.springboot3.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.springboot3.entity.Inventory;

public interface InventoryWithPagingAndSorting extends PagingAndSortingRepository<Inventory, Integer>{

}
