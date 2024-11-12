package com.app.blogger.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogger.entity.Comment;
import com.app.blogger.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("comment/api/v1")
public class CommentController {

	
	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}



	@PostMapping("/addComment/{postId}")
	public Comment addComment(@Valid @RequestBody Comment comment, @PathVariable("postId") String postId) {
		
		commentService.addCommentToPost(postId,comment);
		
		return comment;
		
	}
	
	@PutMapping("/editComment")
	public Comment editComment(@Valid @RequestBody Comment comment ) {
		
		commentService.editCommentToPosts(comment);
		
		return comment;
		
	}
}
