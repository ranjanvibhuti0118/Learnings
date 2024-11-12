package com.app.order.service;

import java.util.List;

import com.app.order.entity.Product;

public interface ProductService {

	List<Product> createProducts(List<Product> cartItems);

}
