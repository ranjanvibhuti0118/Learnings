package com.project.springboot3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.project.springboot3.dao.InventoryWithPagingAndSorting;
import com.project.springboot3.entity.Inventory;
@Service
public class InventoryServiceWithPagAndSortImpl implements InventoryServiceWithPaginationAndSorting{

	@Autowired
	private InventoryWithPagingAndSorting paginationAndSortDao;
	
	@Override
	public Iterable<Inventory> fetchDetails(boolean isAscOrDesc, String... property) {
		
		Sort sort= Sort.by(isAscOrDesc?Direction.ASC:Direction.DESC, property);
		return paginationAndSortDao.findAll(sort);
	}

	@Override
	public List<Inventory> fetchDetailsWithPageableObj(int pageSize, int pageNo) {
		
		
		PageRequest pagereq=PageRequest.of(pageNo, pageSize);
		
		Page<Inventory> paginationInventory = paginationAndSortDao.findAll(pagereq);
		return paginationInventory.getContent();
	}

}
