package com.food.foodorderapplication.entities;

import java.util.Comparator;
import java.util.Map;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class Restaurant{
	@NotBlank(message="Restaurant name is mandatory")
	private String name;
	@Max(value=5,message="Max rating must be less than 5")
	@Min(value=1,message="Min rating must be greater than 1")
	private int rating;
	@Positive(message = "Max order must be greater than zero")
	private int maxOrder;
	@NotEmpty(message="Menu can't be empty")
	private Map<@NotBlank String,@Positive Integer> menu;
	
	public Restaurant() {};
	
	public Restaurant(String name, int rating, Map<String, Integer> menu, int maxOrder) {
		super();
		this.name = name;
		this.rating = rating;
		this.menu = menu;
		this.maxOrder = maxOrder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Map<String, Integer> getMenu() {
		return menu;
	}
	public void setMenu(Map<String, Integer> menu) {
		this.menu = menu;
	}
	public int getMaxOrder() {
		return maxOrder;
	}
	public void setMaxOrder(int maxOrder) {
		this.maxOrder = maxOrder;
	}
	@Override
	public String toString() {
		return "[ "+ this.name + ","+this.rating +","+ this.maxOrder+","+ this.menu+"]";
	}
	public static Comparator<Restaurant> RATING_COMPARATOR =
	        Comparator.comparingInt(Restaurant::getRating).reversed();
	
	public static Comparator<Restaurant> MIN_PRICE_COMPARATOR =
	        Comparator.comparingInt(restaurant ->
	                restaurant.getMenu()
	                          .values()
	                          .stream()
	                          .min(Integer::compareTo)
	                          .orElse(Integer.MAX_VALUE)
	        );
}
