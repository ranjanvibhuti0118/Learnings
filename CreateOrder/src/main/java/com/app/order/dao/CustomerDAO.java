package com.app.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long>{

	public Customer findCustomerByFirstNameAndLastNameAndMobileNo(String sFirstName,String sLastName, String sMobileNo);
}
