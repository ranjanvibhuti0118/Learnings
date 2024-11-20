package com.app.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.user.entity.User;

public interface UserDao extends JpaRepository<User,Long>{

}
