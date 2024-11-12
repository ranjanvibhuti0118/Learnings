package com.project.springboot3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot3.entity.Bootle;

@RestController
public class BottleController {

	@GetMapping("/getBottle")
	public Bootle getBootle(){
		
		System.out.println("This");
		Bootle bottle = new Bootle();
		bottle.setCapacity(1);
		bottle.setCompany("DMART");
		
		return bottle;
		
		
	}
	
}
