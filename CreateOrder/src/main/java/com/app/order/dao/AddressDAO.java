package com.app.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Long>{

	public Address findByAddressLine1AndAddressLine2AndAddressLine3AndZipcode(String addrLine1,String addrLine2,String addrLine3,String zipcode);
	
}
