package com.app.blogger.DTO;

import java.util.Set;

import com.app.blogger.entity.Category;
import com.app.blogger.entity.User;


public interface PostProjection {

	
	Long getPostId();
	String getDescription();
	String getContent();
	Category getCategory();

	Set<CommentProjection> getComments();
	User getUser();

}
