package com.app.blogger.service;

import com.app.blogger.entity.Comment;

public interface CommentService {

	public Comment addCommentToPost(String postId,Comment comment);
	public Comment editCommentToPosts(Comment comment);

	
}
