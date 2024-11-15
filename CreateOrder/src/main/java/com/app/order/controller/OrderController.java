package com.app.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.order.entity.Order;
import com.app.order.service.OrderService;

@RestController
@RequestMapping("/api/order/v1")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(@RequestBody Order order){

		Order savedOrder= orderService.createOrder(order);
		return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);

	}
	
	@PutMapping("/changeOrder")
	public ResponseEntity<Order> changeOrder(@RequestBody Order changedOrder){

		Order savedOrder= orderService.changeOrder(changedOrder);
		
		return new ResponseEntity<Order>(savedOrder,HttpStatus.OK);
	}

}
