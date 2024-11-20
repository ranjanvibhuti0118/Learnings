package com.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.entity.User;
import com.app.user.service.UserService;


@RestController
@RequestMapping("/api/user/v1")
public class UserController {

	@Autowired
	private UserService userService;

	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		
		User savedUser =userService.registerNewUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUserDetails(@PathVariable String userId){
		
		User savedUser =userService.getUserInformation(userId);
		return new ResponseEntity<User>(savedUser,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUserDetails(@RequestBody User user){
		
		User savedUser =userService.upadetUserInfo(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
}
