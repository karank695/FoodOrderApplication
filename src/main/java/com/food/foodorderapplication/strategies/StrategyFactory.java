package com.food.foodorderapplication.strategies;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StrategyFactory {

    private final Map<String, OrderStrategy> strategies;

    public StrategyFactory(List<OrderStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        OrderStrategy::getStrategyName,
                        s -> s
                ));
    }

    public OrderStrategy getStrategy(String strategyName) {
        OrderStrategy strategy = strategies.get(strategyName);
        if (strategy == null) {
            throw new IllegalArgumentException(
                "No strategy found for: " + strategyName
            );
        }
        return strategy;
    }
}

