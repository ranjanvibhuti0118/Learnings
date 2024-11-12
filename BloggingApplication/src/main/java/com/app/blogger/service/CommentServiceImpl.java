package com.app.blogger.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.blogger.dao.CommentDao;
import com.app.blogger.dao.PostDao;
import com.app.blogger.entity.Comment;
import com.app.blogger.entity.Post;
import com.app.blogger.exception.CommentNotFoundException;
import com.app.blogger.exception.InvalidRequestException;
import com.app.blogger.exception.PostNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {
	
	private PostDao postDao;
	private CommentDao commentDao;
	
	
	
	public CommentServiceImpl(PostDao postDao, CommentDao commentDao) {
		super();
		this.postDao = postDao;
		this.commentDao = commentDao;
	}



	public Comment addCommentToPost(String postId,Comment comment) {
		
		if(postId==null) {
			throw new PostNotFoundException(null);

		}
		long lPostId = Long.parseLong(postId);
		
		
		Comment savedComment=null;
		Optional<Post> post=postDao.findById(lPostId);
		if(post.isPresent()) {
			
			 comment.setDateTime(LocalDateTime.now());
			 savedComment= commentDao.save(comment);
			
		}else {
			throw new PostNotFoundException(lPostId);
		}
		
		
		return savedComment;
	}



	@Override
	public Comment editCommentToPosts( Comment comment) {
		
		Post inputPost=comment.getCommentedOnPost();
		
		if(inputPost==null) {
			throw new InvalidRequestException("PostId can not be blank");
		}
		
		if(comment.getCommentId()==null) {
			throw new InvalidRequestException("CommentId can not be blank");

		}
		
		
		
		Comment savedComment=null;
		Optional<Post> post=postDao.findById(inputPost.getPostId());
		if(post.isPresent()) {
		Optional<Comment> coomentInPost=	post.get().getComments().stream().filter(com->com.getCommentId()==comment.getCommentId()).findFirst();
			
			Optional<Comment> existingComment = commentDao.findById(comment.getCommentId());
			if(coomentInPost.isPresent() && existingComment.isPresent()) {
				comment.setDateTime(LocalDateTime.now());
				commentDao.save(comment);
			}else {
				throw new CommentNotFoundException(comment.getCommentId().toString());
			}
			
		}else {
			throw new PostNotFoundException(inputPost.getPostId());
		}
		
		
		return savedComment;
	}
	

}
