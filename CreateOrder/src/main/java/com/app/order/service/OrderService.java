package com.app.order.service;

import com.app.order.entity.Order;

public interface OrderService {

	public Order beforeCreateOrder(Order order);
	public Order createOrder(Order order);
	public Order changeOrder(Order order);
}
