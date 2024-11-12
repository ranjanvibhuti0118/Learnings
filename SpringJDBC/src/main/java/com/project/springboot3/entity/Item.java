package com.project.springboot3.entity;

import org.springframework.stereotype.Component;


public class Item {

	private String id;
	private String name;
	private String description;
	private String size;
	
	
	public Item() {
		super();
	}

	public Item(String id, String name, String description, String size) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.size = size;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", size=" + size + "]";
	}
	
	
	
}
