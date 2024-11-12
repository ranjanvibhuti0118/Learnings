package com.app.blogger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogger.entity.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>{

}
