package com.app.blogger;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TestBean {
	static {
		System.out.println("Print Static block -1");
	}
	
	public TestBean() {

		System.out.println("Constaructor Called-3");
	}
	
	{
		System.out.println("Instance block -2");
	}
	
	void method() {
		System.out.println("Buisness Logic -5");
	}
	
	@PostConstruct
	void init() {
		System.out.println("After Constructor call -4");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("Destroyed in Sec -6");
	}
	
}
