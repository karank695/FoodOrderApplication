package com.food.foodorderapplication.repositories;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.food.foodorderapplication.entities.Restaurant;

@Repository
public class RestaurantRepository {
	private final Map<String,Restaurant> restaurants = new ConcurrentHashMap<>();
	public void addRestaurant(Restaurant restaurant) {
		restaurants.put(restaurant.getName(),restaurant);
	}
	public List<Restaurant> getAllRestaurant(){
		return restaurants.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
	}
	public Restaurant getRestaurant(String resName) {
		return restaurants.getOrDefault(resName, null);
	}
}
