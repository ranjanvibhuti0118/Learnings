package com.project.springboot3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.project.springboot3.dao.InventoryRepoWithJPA;
import com.project.springboot3.entity.Inventory;
import com.project.springboot3.view.InventoryView;
import com.project.springboot3.view.View;
@Service
public class InventoryServiceJPAImpl implements InventoryServiceJPA {

	@Autowired
	private InventoryRepoWithJPA jpa;




	@Override
	public List<Inventory> findAllInventory(Integer invId) {

		Sort sort= Sort.by(Direction.ASC, "itemId");
		Optional<Inventory> inv = jpa.findById(invId);
		Example<Inventory> exp= Example.of(inv.get());	
		return jpa.findAll(exp,sort);
		//		return jpa.findAll(exp);
	}




	@Override
	public List<Inventory> findAllInventorySorted(Iterable<Integer> invId) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public void deleteById(List<Integer> invId) {


		jpa.deleteAllByIdInBatch(invId);

	}




	@Override
	public List<InventoryView> fetchInventoryByItem(String itemId) {

		return jpa.findByitemId(itemId);
	}




	@Override
	public <T extends View> List<T> fetchInventoryByItemDynamic(String itemId, Class<T> cls) {

		jpa.findByitemId(itemId,cls);
		return null;
	}




	@Override
	public Inventory getInventoryById(int id) {

		return jpa.fetchInventoryById(id);
	}




	@Override
	public int deleteMyInventoryById(int id) {

		return jpa.removeInventoryById(id);
	}




	@Override
	public int createInventory(int id, String node, int quantity, String itemId) {

		
		return jpa.insetIntoInvetory(id, node, quantity, itemId);
	}


}
