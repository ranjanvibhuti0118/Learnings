package com.app.order.service;

import com.app.order.entity.Address;
import com.app.order.entity.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer cust,Address address);
	
}
