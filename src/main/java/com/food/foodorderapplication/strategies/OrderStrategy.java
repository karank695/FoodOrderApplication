package com.food.foodorderapplication.strategies;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.food.foodorderapplication.entities.Order;

@Service
public interface OrderStrategy {
	Map<String,Integer> assignOrder(Order order);
	String getStrategyName();
}
