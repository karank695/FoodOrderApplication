package com.food.foodorderapplication.utilities;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.food.foodorderapplication.entities.Restaurant;
import com.food.foodorderapplication.repositories.OrderRepository;

@Component
public class Utility {

	
	public static void assignOrderForRestaurant(Map<String, Integer> assignedRestAndCost, Map<String, Integer> itemList,
			List<Restaurant> restaurants, OrderRepository orderRepository) {
		int i=0;
		int price=0;
		Restaurant r=null;
		int itemCount = itemList.size();
		for(Map.Entry<String,Integer> e:itemList.entrySet()) {
			String it = e.getKey();
			r = restaurants.get(i);
			Map<String,Integer> menuList = r.getMenu();
			if(menuList.containsKey(it) && orderRepository.getOrderCount(r.getName())<r.getMaxOrder()) {
				price+= e.getValue()*menuList.get(it);
				itemCount--;
			}else {
				r = restaurants.get(++i);
				int j = i;
				while(j<restaurants.size()) {
					Map<String,Integer> menuList1 = restaurants.get(j).getMenu();
					if(!menuList1.containsKey(it)) {
						r = restaurants.get(j);
						j++;
					}else {
						i=0;
						orderRepository.addOrderForRestaurant(restaurants.get(j).getName());
						price=e.getValue()*menuList1.get(it);
						if(price!=0)
						assignedRestAndCost.put(r.getName(), assignedRestAndCost.getOrDefault(r.getName(), 0)+price);
						price=0;
						itemCount--;
						break;
					}
				}
				
			}
		}
		if(r!=null) {
			assignedRestAndCost.put(r.getName(), price);
		}
		if(itemCount!=0) {
			throw new RuntimeException("Order can't be placed");
		}
	}
}
