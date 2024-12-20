package com.app.springbatch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springbatch.entity.Inventory;
import com.app.springbatch.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepo invRepo;
	
	
	@Override
	public Inventory findInventory(String productId, String qty) {
		Inventory defaultInv=null;
		Long lProductId= Long.parseLong(productId);
		Integer iQty= Integer.parseInt(qty);
		Inventory existingInventory = invRepo.findByProductProductId(lProductId);
				
		if(existingInventory!=null) {
			
			if(existingInventory.getQty()<iQty) {
				defaultInv = new Inventory();
				defaultInv.setInventroyId(null);
				defaultInv.setInventroyId(lProductId);
				defaultInv.setQty(0);
				return defaultInv;
			}else {
				return existingInventory;
			}
			
			
		}else {
			defaultInv = new Inventory();
			defaultInv.setInventroyId(null);
			defaultInv.setInventroyId(lProductId);
			defaultInv.setQty(0);
			return defaultInv;
		}
		
	}


	@Override
	public Inventory updateInventory(Inventory inv) {
		
		Long lInvId=inv.getInventroyId();
		if(lInvId!=null) {
			Optional<Inventory> existingInv = invRepo.findById(lInvId);
			if(existingInv.isPresent()) {
				return invRepo.save(inv);
			}

		}
		return null;
	}

}
