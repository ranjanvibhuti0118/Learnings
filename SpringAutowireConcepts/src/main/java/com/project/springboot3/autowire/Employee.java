package com.project.springboot3.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Employee {

	private String firstName;
	private String lastName;

	public Employee() {
	System.out.println("Emp cons");
	}
	
	public String role() {
		return "A Employee can be dev";
	}

    @Bean
    Employee getEmp() {
		return new Employee();
	}
}
