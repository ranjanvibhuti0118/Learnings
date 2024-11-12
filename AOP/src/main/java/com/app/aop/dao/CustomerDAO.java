package com.app.aop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.aop.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
