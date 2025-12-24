package com.food.foodorderapplication.controllers;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodorderapplication.entities.Order;
import com.food.foodorderapplication.entities.Response;
import com.food.foodorderapplication.services.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {

	private OrderService orderService;
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	@GetMapping("/orderTest")
	public String test() {
		return "You can placeOrder";
	}
	@PostMapping("/place")
	public ResponseEntity<Response> placeOrder(@Valid @RequestBody Order o){
		Map<String,Integer> data =  orderService.makeOrder(o);
		Response res = new Response();
		res.setMessage("Order is placed");
		res.setResponseCode("200");
		res.setTimeStamp(LocalDate.now().toString());
		res.setData(data.toString());
		return ResponseEntity.ok(res);
	}
}
