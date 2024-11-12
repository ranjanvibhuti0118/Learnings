package com.project.springboot3.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Developer {

	private String techStack;
	private int experience;
	private String domain;
	
	@Autowired
 	Employee e1;
	
	Developer(){
		
		System.out.println("Developer Constructor");
	}
	
	
	
	public String getTechStack() {
		return techStack;
	}



	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}



	public int getExperience() {
		return experience;
	}



	public void setExperience(int experience) {
		this.experience = experience;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public String role() {
		e1.getEmp();
		e1.role();
		return e1.role();
	}
	
	
	
}
