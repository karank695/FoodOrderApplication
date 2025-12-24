package com.food.foodorderapplication.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.food.foodorderapplication.entities.Order;

@Repository
public class OrderRepository {
	private final Map<String,Order> orderList=new ConcurrentHashMap<>();
	private final Map<String, Integer> orderPerRestaurant = new HashMap<>();
	private RestaurantRepository restaurantRepository;
	public OrderRepository(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	public void addOrder(Order o) {
		orderList.put(o.getUserName(),o);
		System.out.println(orderList.toString());
	}
	public Order getOrder(String userName) {
		return orderList.getOrDefault(userName, null);
	}
	public boolean addOrderForRestaurant(String restaurantName) {
		int maxOrder = restaurantRepository.getRestaurant(restaurantName).getMaxOrder();
		System.out.println("maxOrder in restaurant:"+maxOrder);
		if(orderPerRestaurant.get(restaurantName)!=null && orderPerRestaurant.get(restaurantName).intValue()>maxOrder) {
			return false;
		}
		orderPerRestaurant.put(restaurantName, orderPerRestaurant.getOrDefault(restaurantName, 0));
		return true;
	}
	public int getOrderCount(String restaurantName) {
		return orderPerRestaurant.getOrDefault(restaurantName, 0);
	}
	

}
