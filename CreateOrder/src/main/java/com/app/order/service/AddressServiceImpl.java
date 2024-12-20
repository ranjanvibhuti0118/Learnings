package com.app.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.order.dao.AddressDAO;
import com.app.order.entity.Address;

@Service
public class AddressServiceImpl  implements AddressService{

	@Autowired
	AddressDAO addrDao;


	@Override
	public Address getAddress(Address address) {

		Address existingAddress = addrDao.findByAddressLine1AndAddressLine2AndAddressLine3AndZipcode(address.getAddressLine1(), 
				address.getAddressLine2(),
				address.getAddressLine3(),
				address.getZipcode());

		if(existingAddress==null) {
			address = addrDao.save(address);
		}else {
			address.setAddressId(existingAddress.getAddressId());
		}

		return address;
	}


}
