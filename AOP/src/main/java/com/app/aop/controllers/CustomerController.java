package com.app.aop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.aop.model.Customer;
import com.app.aop.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		List<Customer> allCustomers = custService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);		
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomers(@RequestBody Customer cust){
		
		Customer newCust=custService.creaetCustomer(cust);
		return new ResponseEntity<Customer>	(newCust,HttpStatus.CREATED);
	}
}
