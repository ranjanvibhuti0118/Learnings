package com.app.blogger.service;

import java.util.Set;

import com.app.blogger.entity.User;

public interface UserService {

	public User createNewUser(User user);
	public User checkForExistingUser(String email);
	public Set<User> fetchAllUser();
	public User findUserById(String userId);
}
