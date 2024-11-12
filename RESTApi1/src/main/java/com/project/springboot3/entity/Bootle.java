package com.project.springboot3.entity;

public class Bootle {

	private int Capacity;
	private String Company;
	
	
	
	public Bootle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	@Override
	public String toString() {
		return "Bootle [Capacity=" + Capacity + ", Company=" + Company + "]";
	}
	
}
