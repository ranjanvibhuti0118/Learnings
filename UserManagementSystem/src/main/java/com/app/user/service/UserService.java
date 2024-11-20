package com.app.user.service;

import com.app.user.entity.User;

public interface UserService {

	User registerNewUser(User user);
	User getUserInformation(String  userId);
	User upadetUserInfo(User user);
}
