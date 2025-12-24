package com.food.foodorderapplication.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.food.foodorderapplication.entities.Restaurant;
import com.food.foodorderapplication.globalExceptionHandlers.ResourceNotFoundException;
import com.food.foodorderapplication.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	private RestaurantRepository restaurantRepository;
	public RestaurantService(RestaurantRepository restaurantRepository) {
	    this.restaurantRepository = restaurantRepository;
	}
	public void addRestaurant(Restaurant r) {
		restaurantRepository.addRestaurant(r);
		System.out.println("Restaurant added successfully: "+r);
	}
	public Map<String,Integer> updateMenu(String resName,Map<String,String> menuList){
		Restaurant updateRes = restaurantRepository.getRestaurant(resName);
		if(updateRes==null) {
			throw new ResourceNotFoundException("Restaurant not exist in our database");
		}
		Map<String, Integer> resMenuList = updateRes.getMenu();
		menuList.entrySet().stream().forEach(e->{
			resMenuList.put(e.getKey(), Integer.parseInt(e.getValue()));
		});
		return resMenuList;
	}

}
