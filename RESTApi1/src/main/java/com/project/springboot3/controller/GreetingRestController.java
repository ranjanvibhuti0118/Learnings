package com.project.springboot3.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {
	
	@GetMapping("/greet")
	public ResponseEntity<String> generateGreeting(){
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		
		int hr= dateTime.getHour();
		String response=null;
		if(hr>12) {
			response="Good Morning";
		}
		else {
			response= "Good Evevening";
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
		
		
	}
	
	//RestController=Controller+ResponseBody

}
