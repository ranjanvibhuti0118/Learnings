package com.app.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.springbatch.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
