package com.app.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.user.dao.UserDao;
import com.app.user.entity.User;

import ch.qos.logback.core.util.StringUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User registerNewUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User upadetUserInfo(User user) {
		
		Long lUserId= user.getId();
		if(lUserId!=null) {
			
			Optional<User> existingUser=userDao.findById(lUserId);
			if(existingUser.isPresent()) {
				
				String sEmail= user.getEmail();
				String sFirstName= user.getFirstName();
				String sLastName= user.getLastName();
				String sPassword= user.getPassword();
				String sUsername= user.getUsername();
				
				User userById= existingUser.get();

				if(sEmail!=null &&  !sEmail.isEmpty() && !sEmail.equals(userById.getEmail())) {
					userById.setEmail(sEmail);
				}
				if(sFirstName!=null &&  !sFirstName.isEmpty() && !sFirstName.equals(userById.getFirstName())) {
					userById.setFirstName(sFirstName);
				}
				if(sLastName!=null &&  !sLastName.isEmpty() && !sLastName.equals(userById.getLastName())) {
					userById.setLastName(sLastName);
				}
				if(sPassword!=null &&  !sPassword.isEmpty() && !sPassword.equals(userById.getPassword())) {
					userById.setPassword(sPassword);
				}
				if(sUsername!=null &&  !sUsername.isEmpty() && !sUsername.equals(userById.getUsername())) {
					userById.setPassword(sPassword);
				}
				
				userDao.save(userById);
			}
			
		}
		return null;
	}

	@Override
	public User getUserInformation(String userId) {

	
		if(userId!=null) {
			
			 Optional<User> existingUser = userDao.findById(Long.parseLong(userId));
			 if(existingUser.isPresent()) {
				 return existingUser.get();
			 }
		}
		return null;
	}

}
