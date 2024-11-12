package com.app.blogger.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blogger.dao.UserDao;
import com.app.blogger.entity.User;
import com.app.blogger.exception.InternalServerException;
import com.app.blogger.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User createNewUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User checkForExistingUser(String email) {
		User existingUserDetails = userDao.findByEmail(email);
		if(existingUserDetails!=null) {
			return existingUserDetails;
		}
		
		return null;
	}

	@Override
	public Set<User> fetchAllUser() {
		
		return userDao.findAll().stream().collect(Collectors.toSet());
	}

	@Override
	public User findUserById(String userId) {
		Optional<User> existingUser=null;
		Long lUID=null;
		User userData=null;
		if(userId!=null) {
			lUID=Long.parseLong(userId);
			boolean userExists = userDao.existsById(lUID);

			if(userExists) {
				existingUser = userDao.findById(lUID);
			}
		}else {
			throw new InternalServerException();
		}
		
		if(existingUser!=null) {
			userData= existingUser.get();
		}else {
			throw new UserNotFoundException(lUID);
		}
		
		return userData;
	}
	
	
}
