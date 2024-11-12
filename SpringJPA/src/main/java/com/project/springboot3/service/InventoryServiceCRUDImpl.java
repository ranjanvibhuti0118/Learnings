package com.project.springboot3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot3.dao.InventoryRepoWithCRUDRepository;
import com.project.springboot3.entity.Inventory;

@Service
public class InventoryServiceCRUDImpl implements InventoryServiceCRUD {

	@Autowired
	private InventoryRepoWithCRUDRepository repo;
	
	@Override
	public Iterable<Inventory> findInventroyForNode(String node) {
		
		Iterable<Inventory> list = repo.findAll();
		return list;
	}

	@Override
	public Inventory updateStock(Inventory inv) {
		
		Inventory invDb= repo.save(inv);
		return invDb;
	}

	@Override
	public Iterable<Inventory> bulkUpdateStock(Iterable<Inventory> listInv) {
		Iterable<Inventory> var = repo.saveAll(listInv);
		return var;
	}

	public void deleteInventory(Inventory inv) {
			Optional<Inventory> invExists = repo.findById(inv.getInventoryId());
		
			if(invExists.isPresent()) {
				repo.deleteById(inv.getInventoryId());
			}
	}

	
}
