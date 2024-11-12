package com.project.springboot3.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.springboot3.entity.Inventory;
public interface InventoryRepoWithCRUDRepository extends CrudRepository<Inventory, Integer> {

}

//CrudRepository generally contains methods for basic CRUD operation
//Extends Repository