package com.app.blogger.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.blogger.DTO.PostProjection;
import com.app.blogger.entity.Post;

public interface PostDao extends JpaRepository<Post, Long>{

	@Query("SELECT p FROM Post p")
	Set<PostProjection> getAllPost();
}
