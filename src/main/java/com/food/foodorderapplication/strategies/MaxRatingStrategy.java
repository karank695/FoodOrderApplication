package com.food.foodorderapplication.strategies;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.food.foodorderapplication.entities.Order;
import com.food.foodorderapplication.entities.OrderStatus;
import com.food.foodorderapplication.entities.Restaurant;
import com.food.foodorderapplication.repositories.OrderRepository;
import com.food.foodorderapplication.repositories.RestaurantRepository;
import com.food.foodorderapplication.utilities.Utility;

@Service
public class MaxRatingStrategy implements OrderStrategy {

	private RestaurantRepository restaurantRepository;
	private OrderRepository orderRepository;
	public MaxRatingStrategy(RestaurantRepository restaurantRepository,OrderRepository orderRepository){
		this.orderRepository=orderRepository;
		this.restaurantRepository=restaurantRepository;
	}
	@Override
	public Map<String,Integer> assignOrder(Order order) {
		order.setStatus(OrderStatus.ACCEPTED);
		orderRepository.addOrder(order);
		Map<String, Integer> assignedRestAndCost = new HashMap<>();
		Map<String,Integer> itemList = order.getItemList();
		List<Restaurant> restaurants = restaurantRepository.getAllRestaurant();
		Collections.sort(restaurants, Restaurant.RATING_COMPARATOR);
		Utility.assignOrderForRestaurant(assignedRestAndCost, itemList, restaurants,orderRepository);
		return assignedRestAndCost;
	}
	@Override
	public String getStrategyName() {
		return Strategies.MAXRATING.toString();
	}

}
