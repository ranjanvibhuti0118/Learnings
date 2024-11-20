package com.app.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.consumer.DTO.User;
import com.app.consumer.entity.Consumer;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/greet")
	public ResponseEntity<Consumer> getGreetings(){
		
		User user= template.getForObject("http://USERMANAGEMENTSYSTEM/api/user/v1/getUser/1", User.class);
		
		Consumer consumer=new Consumer();
		consumer.setMessage("Hello "+ user.getFirstName());
		return new ResponseEntity<Consumer>(consumer,HttpStatus.OK);
		
	}
}