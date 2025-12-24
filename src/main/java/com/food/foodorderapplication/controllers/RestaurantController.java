package com.food.foodorderapplication.controllers;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodorderapplication.entities.Response;
import com.food.foodorderapplication.entities.Restaurant;
import com.food.foodorderapplication.services.RestaurantService;

import jakarta.validation.Valid;

@RestController
public class RestaurantController {
	private final RestaurantService restaurantService;
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	@GetMapping("/test")
	public String test() {
		return "you are using foodApplication";
	}
	@PostMapping("/restaurant")
	public ResponseEntity<Response> addRestaurant(@Valid @RequestBody Restaurant r) {
		Response response = new Response();
		try {
			restaurantService.addRestaurant(r);
		}catch(Exception e) {
			response.setMessage("Error occured while adding restaurant");
			response.setMessage("500");
			response.setTimeStamp(LocalDate.now().toString());
			return ResponseEntity.ok(response);
		}
		response.setMessage("Restaurant added successfully: "+r.getName());
		response.setResponseCode("201");
		response.setTimeStamp(LocalDate.now().toString());
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/menu/{restaurantName}")
	public ResponseEntity<Response> updateRestaurantMenu(@RequestBody Map<String,String> list, @PathVariable String restaurantName){
		Map<String, Integer> data = restaurantService.updateMenu(restaurantName, list);
		Response rs = new Response();
		rs.setData(data.toString());
		rs.setMessage("Menu list updated successfully for "+restaurantName);
		rs.setResponseCode("200");
		rs.setTimeStamp(LocalDate.now().toString());
		return ResponseEntity.ok(rs);
	}
}
