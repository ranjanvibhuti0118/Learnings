package com.app.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springbatch.entity.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Long>{

	
	public Inventory findByProductProductId(Long lProductId);
	
}
