package com.app.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long studentId;
	
	private String studentClass;
	private String rollNo; 
}
