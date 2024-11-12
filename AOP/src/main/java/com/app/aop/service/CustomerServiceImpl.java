package com.app.aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aop.dao.CustomerDAO;
import com.app.aop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO dao;
	
	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = dao.findAll();
		return customers;
	}

	@Override
	public Customer creaetCustomer(Customer cust) {

		Customer newCust=null;
		if(cust!=null) {
			newCust=	dao.save(cust);
		}
		return newCust;
	}

	
}
