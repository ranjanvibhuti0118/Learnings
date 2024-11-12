package com.app.blogger.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.blogger.DTO.PostProjection;
import com.app.blogger.entity.Post;
import com.app.blogger.service.PostService;

@RestController
public class PostController {


	@Autowired
	private PostService service;

	@GetMapping("/posts")
	public ResponseEntity<Set<PostProjection>> getAllPost() {

		Set<PostProjection> allPosts=service.getAllPost();

		return new ResponseEntity<Set<PostProjection>>(allPosts,HttpStatus.OK);

	}
	
	@PostMapping("/post/create")
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
		
		Post savedPost= service.createPost(post);

		return new ResponseEntity<Post>(savedPost,HttpStatus.CREATED);

	}
	
	@PutMapping("/post/update")
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
			
		Post savedPost= service.updatePost(post);

		return new ResponseEntity<Post>(savedPost,HttpStatus.OK);

	}
}
