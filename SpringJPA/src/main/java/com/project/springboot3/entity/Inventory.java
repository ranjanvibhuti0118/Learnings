package com.project.springboot3.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;
	private String node;
	private Integer quantity;
	private String itemId;
	private LocalDateTime expiryDate;
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Inventory(String node, Integer quantity, String itemId, LocalDateTime expiryDate) {
		super();
		this.node = node;
		this.quantity = quantity;
		this.itemId = itemId;
		this.expiryDate = expiryDate;
	}


	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Inventory [ node=" + node + ", quantity=" + quantity + ", itemId="
				+ itemId + ", expiryDate=" + expiryDate + "]";
	}

	
}
