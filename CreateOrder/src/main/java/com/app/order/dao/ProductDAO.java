package com.app.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.entity.Customer;
import com.app.order.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

	Product findProductByProductNameAndDescription(String productName, String description);

}
