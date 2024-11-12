package com.app.blogger.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	
	@Column(nullable = false)
	private String description;
	
	private String content;	
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "commentedOnPost")
	private List<Comment> comments;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(
	        name = "post_category", 
	        joinColumns = @JoinColumn(name = "post_id"), 
	        inverseJoinColumns = @JoinColumn(name = "category_id")) 
	private Set<Category> category = new HashSet<>();
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String description, String content, User user, Set<Category> category) {
		super();
		this.description = description;
		this.content = content;
		this.user = user;
		this.category = category;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", description=" + description + ", content=" + content + ", user=" + user
				+ ", comments=" + comments + ", category=" + category + "]";
	}


	


	

	
}
