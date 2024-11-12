package com.app.blogger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blogger.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	public User findByEmail(String email);
}
