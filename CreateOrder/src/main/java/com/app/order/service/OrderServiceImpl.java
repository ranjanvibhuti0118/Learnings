package com.app.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.dao.OrderDAO;
import com.app.order.dao.ProductDAO;
import com.app.order.entity.Address;
import com.app.order.entity.Customer;
import com.app.order.entity.Order;
import com.app.order.entity.Product;
import com.app.order.exception.OrderNumberNotUniqueException;
import com.app.order.kafkaservice.KafkaProducerService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDao;

	@Autowired
	ProductDAO productDao;

	@Autowired
	private CustomerService custService;

	@Autowired
	private AddressService addrService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private KafkaProducerService kafkaService;
	
	@Transactional
	@Override
	public Order createOrder(Order order) {
		beforeCreateOrder(order);
		
		Order savedOrder=null;
		Long lOrderId= order.getOrderId();

		System.out.println("OrderId "+lOrderId);
		if(lOrderId==null) {
			
			savedOrder=orderDao.save(order);
			
			kafkaService.sendMessage(savedOrder);

		}else {
			Optional<Order> existingOrder=orderDao.findById(lOrderId);	

			if(existingOrder.isPresent()) {
				throw new OrderNumberNotUniqueException("Order with OrderId "+ existingOrder.get().getOrderId() + " already exists");

			}

		}

		return savedOrder;
	}

	@Override
	public Order beforeCreateOrder(Order order) {
		
		Customer customer= order.getCustomer();
		Address address= customer.getAddresses();
		List<Product> cartItems= order.getProducts();


		List<Product> savedProducts = productService.createProducts(cartItems);
		Address savedAddress= addrService.getAddress(address);
		Customer savedCustomer= custService.createCustomer(customer,savedAddress);

		order.setCustomer(savedCustomer);
		order.setProducts(savedProducts);

		return order;
	}

	@Override
	public Order changeOrder(Order order) {
		
		Order savedOrder=null;
		Long lOrderId=order.getOrderId();
		if(lOrderId!=null) {
			Optional<Order> existingOrder = orderDao.findById(lOrderId);
			if(existingOrder.isPresent() ) {
				
				String changedOrderStatus=order.getOrderStatus();
				
				if(changedOrderStatus!=null) {
					existingOrder.get().setOrderStatus(changedOrderStatus);
				}
				
				savedOrder=orderDao.save(existingOrder.get());
			}
		}
		
		return savedOrder;
	}

	
}
