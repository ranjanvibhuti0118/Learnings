package com.app.blogger.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	@NotEmpty
	private String commentDescription;
	
	@OneToOne
	private Post commentedOnPost;
	
	private LocalDateTime dateTime;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
	public Post getCommentedOnPost() {
		return commentedOnPost;
	}
	public void setCommentedOnPost(Post commentedOnPost) {
		this.commentedOnPost = commentedOnPost;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDescription=" + commentDescription + ", commentedOnPost="
				+ commentedOnPost + ", dateTime=" + dateTime + "]";
	}
	

	
}
