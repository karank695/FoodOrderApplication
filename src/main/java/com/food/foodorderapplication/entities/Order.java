package com.food.foodorderapplication.entities;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Order {
	@NotBlank(message = "userName must required")
	private String userName;
	private Map<@NotEmpty String,@Positive Integer> itemList = new HashMap<>();
	@NotBlank
	private String strategy;
	private OrderStatus status;
	
	public Order() {}
	public Order(String userName, Map<String, Integer> itemList, String strategy, OrderStatus status) {
		super();
		this.userName = userName;
		this.itemList = itemList;
		this.strategy = strategy;
		this.status = status;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Integer> getItemList() {
		return itemList;
	}
	public void setItemList(Map<String, Integer> itemList) {
		this.itemList = itemList;
	}
	
}
