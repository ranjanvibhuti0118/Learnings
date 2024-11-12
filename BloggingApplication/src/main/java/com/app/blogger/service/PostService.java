package com.app.blogger.service;

import java.util.Set;

import com.app.blogger.DTO.PostProjection;
import com.app.blogger.entity.Category;
import com.app.blogger.entity.Post;

public interface PostService {

	Set<Category> getCategoryForPost(Long postId);
	Set<PostProjection> getAllPost();
	Post createPost(Post post);
	Post updatePost(Post post);
	
}
