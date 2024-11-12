package com.app.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.order.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{

}
