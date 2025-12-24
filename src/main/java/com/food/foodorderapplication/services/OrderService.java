package com.food.foodorderapplication.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.food.foodorderapplication.entities.Order;
import com.food.foodorderapplication.strategies.OrderStrategy;
import com.food.foodorderapplication.strategies.StrategyFactory;

@Service
public class OrderService {

    private final StrategyFactory strategyFactory;

    public OrderService(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    public Map<String, Integer> makeOrder(Order order) {
        OrderStrategy strategy =
                strategyFactory.getStrategy(order.getStrategy());
        return strategy.assignOrder(order);
    }
}

