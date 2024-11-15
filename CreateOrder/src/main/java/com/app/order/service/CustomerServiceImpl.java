package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.dao.AddressDAO;
import com.app.order.dao.CustomerDAO;
import com.app.order.entity.Address;
import com.app.order.entity.Customer;
import com.app.order.exception.CustomerDetailsNotFound;
import com.app.order.exception.OrderProcessingException;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO custDao;

	@Autowired
	private AddressDAO addrDao;

	@Override
	@Transactional
	public Customer createCustomer(Customer cust,Address address) {

		String sFirstName= cust.getFirstName();
		String sLastName= cust.getLastName();
		String sMobileNum= cust.getMobileNo();
		if(sFirstName==null || sLastName ==null || sMobileNum==null) {
			throw new CustomerDetailsNotFound("Customer info is mandatory");
		}
		Customer existingCust = custDao.findCustomerByFirstNameAndLastNameAndMobileNo(sFirstName, sLastName, sMobileNum);
		if(existingCust==null) {
			cust.setAddresses(address);
			Customer savedCustomer= custDao.save(cust);
			return savedCustomer;
		}else {

			cust.setAddressId(String.valueOf(address.getAddressId()));
			cust.setCustomerId(existingCust.getCustomerId());
			return cust;

		}

	}

}
