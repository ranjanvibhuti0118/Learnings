package com.app.blogger.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long categoryId;

	@Column(nullable = false)
	private String categoryDescription;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
	private Set<Post> allPostByCategory = new HashSet<>();



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryDescription() {
		return categoryDescription;
	}



	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}



	public Set<Post> getAllPostByCategory() {
		return allPostByCategory;
	}



	public void setAllPostByCategory(Set<Post> allPostByCategory) {
		this.allPostByCategory = allPostByCategory;
	}



	



}
