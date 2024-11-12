package com.app.aop.service;

import java.util.List;

import com.app.aop.model.Customer;

public interface CustomerService {

List<Customer> getAllCustomers();
Customer creaetCustomer(Customer cust);
}
