package com.app.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.dao.ProductDAO;
import com.app.order.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDao;

	@Override
	public List<Product> createProducts(List<Product> cartItems) {

		List<Product> savedItems= new ArrayList<>();
		for(Product product:cartItems) {

			Product existingProduct= productDao.findProductByProductNameAndDescription(product.getProductName(),product.getDescription());

			System.out.println("existing product " +existingProduct);
			if(existingProduct==null) {
				Product savedProduct= productDao.save(product);
				savedItems.add(savedProduct);
			}else{
				product.setProductId(existingProduct.getProductId());
				savedItems.add(product);
			}

		}
		System.out.println("Saved Product "+ savedItems);
		return savedItems;
	}

}
