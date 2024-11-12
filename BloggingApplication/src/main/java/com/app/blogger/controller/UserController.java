package com.app.blogger.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogger.entity.User;
import com.app.blogger.exception.UserAlreadyExistException;
import com.app.blogger.service.UserService;

@RestController
public class UserController {

	private UserService userService=null;


	@Autowired
	public UserService getUserService(UserService user) {
		return userService=user;
	}



	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception{

		String sUserEmailAddress=user.getEmail();
		User existingUserData= userService.checkForExistingUser(sUserEmailAddress);
		if(existingUserData!=null) {
			throw new UserAlreadyExistException("User Already Exists");
		}

		User savedUser = userService.createNewUser(user);

		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<Set<User>> getAllUser() throws Exception{

		Set<User> users= userService.fetchAllUser();
		return new ResponseEntity<Set<User>>(users,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable("userId") String userId ) throws Exception{

				User user= userService.findUserById(userId);
				return new ResponseEntity<User>(user,HttpStatus.OK);
	}


}
