package com.app.blogger.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.app.blogger.DTO.PostProjection;
import com.app.blogger.dao.CategoryDao;
import com.app.blogger.dao.PostDao;
import com.app.blogger.dao.UserDao;
import com.app.blogger.entity.Category;
import com.app.blogger.entity.Post;
import com.app.blogger.entity.User;
import com.app.blogger.exception.CategoryNotFoundException;
import com.app.blogger.exception.PostNotFoundException;
import com.app.blogger.exception.PostNotTransferableException;

@Service
@Primary
public class PostServiceImpl implements PostService{


	private PostDao postDao;
	private CategoryDao catDao;
	private UserDao userDao;

	public PostServiceImpl(PostDao postDao,CategoryDao catDao,UserDao userDao) {
		super();
		this.postDao = postDao;
		this.catDao=catDao;
		this.userDao=userDao;
	}




	@Override
	public Set<Category> getCategoryForPost(Long postId) {

		Set<Category> catList=new HashSet<>();
		Optional<Post> post= postDao.findById(postId);

		Post postObj=null;
		if(post.isPresent()) {
			postObj=post.get();
		}

		if(postObj!=null) {
			catList= postObj.getCategory();
		}

		return catList;
	}




	@Override
	public Set<PostProjection> getAllPost() {

//		return postDao.findAll().stream().collect(Collectors.toSet());
		return postDao.getAllPost();

	}




	@Override
	public Post createPost(Post post) {

		Set<Category> categoryList=post.getCategory();
		Set<Category> updatedCategoryList= new HashSet<>();
		categoryList.stream().forEach(cat->{

			Long catId=cat.getCategoryId();
			if(catId==null) {
				String catDesc= cat.getCategoryDescription();

				Category category= new Category();
				category.setCategoryDescription(catDesc);
				updatedCategoryList.add(category);

			}else {
				Optional<Category> categoryExist=catDao.findById(catId);
				if(!categoryExist.isPresent()) {
					throw new CategoryNotFoundException(catId);
				}

			}			
		});

		post.setCategory(updatedCategoryList);

		//ToDo :Fetch Logged In User add to post
		/*
		 * User user = post.getUser(); Long userId= user.getUserId();
		 * System.out.println(userId);
		 * 
		 * if(userId==null) { post.setUser(user); }else { Optional<User>
		 * userExist=userDao.findById(userId); if(!userExist.isPresent()) { throw new
		 * UserNotFoundException(userId); } }
		 */

		Post savedPost = postDao.save(post);
		Optional<Post> getpost = postDao.findById(savedPost.getPostId());

		return getpost.get();
	}




	@Override
	public Post updatePost(Post updatedPost) {
		Long postId=updatedPost.getPostId();
		Optional<Post> existingPostData= postDao.findById(postId);
		if(!existingPostData.isPresent()) {
			throw new PostNotFoundException(postId);
		}


		Post existingPost= existingPostData.get();


		if(!existingPost.getContent().equals(updatedPost.getContent())) {
			existingPost.setContent(updatedPost.getContent());
		}

		if(!existingPost.getDescription().equals(updatedPost.getDescription())) {
			existingPost.setDescription(updatedPost.getDescription());
		}
		
		Set<Category> existingCategory=existingPost.getCategory();

		Set<Category> updatedCategorySet= getUpdatedCategory(existingCategory,updatedPost.getCategory());
		

		existingPost.setCategory(updatedCategorySet);

		User existingUser = existingPost.getUser();
		User newUser= updatedPost.getUser(); 
		if(existingUser==null) {
			existingPost.setUser(newUser);
		}else {
			if(newUser.getUserId()!=null && existingUser.getUserId()!=newUser.getUserId()) {
				throw new PostNotTransferableException(postId);
			}
		}
		postDao.save(existingPost);
		existingPost.setComments(null);
		
		return existingPost;


	}




	private Set<Category> getUpdatedCategory(Set<Category> existingCategory, Set<Category> updatedCategory) {
		
		
		updatedCategory.stream().forEach(cat->{
			Long categoryId= cat.getCategoryId();
			if(categoryId==null) {
				throw new CategoryNotFoundException(categoryId);
			}
			
			
			
			Optional<Category> categoryExists = catDao.findById(categoryId);
			if(categoryExists.isPresent()) {

				Optional<Category> exists = existingCategory.stream().filter(category->category.getCategoryId()==categoryExists.get().getCategoryId()).findFirst();

				if(!exists.isPresent()) {
					existingCategory.add(cat);
				}
			}else {
				throw new CategoryNotFoundException(categoryId);
			}

		});

		
		return existingCategory;
	}


}
