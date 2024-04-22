package com.example.restaurantmanagementsystem;

import com.example.restaurantmanagementsystem.factory.RestaurantFinderFactory;
import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Restaurant;
import com.example.restaurantmanagementsystem.model.RestaurantCriteria;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.order.OrderRepository;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;
import com.example.restaurantmanagementsystem.service.OrderManagementService;
import com.example.restaurantmanagementsystem.service.RestaurantManagementService;

import java.util.HashMap;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		RestaurantRepository restaurantRepository = new RestaurantRepository();
		MenuRepository menuRepository = new MenuRepository();
		OrderRepository orderRepository = new OrderRepository(restaurantRepository);
		RestaurantFinderFactory restaurantFinderFactory = new RestaurantFinderFactory(menuRepository, restaurantRepository);
		RestaurantManagementService restaurantManagementService = new RestaurantManagementService(restaurantRepository, menuRepository);
		Restaurant restaurant1 = new Restaurant(1, 5, "Res1", 2, 0, 1);
		Restaurant restaurant2 = new Restaurant(2, 4, "Res2", 2, 0, 2);
		restaurantManagementService.addRestaurant(restaurant1);
		List<FoodItem> foodItems = List.of(new FoodItem(1, "Burger", 100), new FoodItem(2, "Pizza", 100));
		restaurantManagementService.addMenuToRestaurant(foodItems, 1);
		restaurantManagementService.addRestaurant(restaurant2);
		foodItems = List.of(new FoodItem(1, "Burger", 50), new FoodItem(2, "Pizza", 50));
		restaurantManagementService.addMenuToRestaurant(foodItems, 2);

		OrderManagementService orderManagementService = new OrderManagementService(orderRepository, menuRepository, restaurantFinderFactory);

		HashMap<FoodItem, Integer> foodItemsMap = new HashMap<>();
		foodItemsMap.put(new FoodItem(1, "Burger"), 4);

		orderManagementService.placeOrder("User1", foodItemsMap, RestaurantCriteria.HIGHEST_RATING);
		orderManagementService.placeOrder("User1", foodItemsMap, RestaurantCriteria.LOWEST_COST);
		orderManagementService.placeOrder("User1", foodItemsMap, RestaurantCriteria.LOWEST_COST);
		orderManagementService.placeOrder("User1", foodItemsMap, RestaurantCriteria.LOWEST_COST);
		orderManagementService.placeOrder("User1", foodItemsMap, RestaurantCriteria.LOWEST_COST);
		orderManagementService.showOrders();
		restaurantManagementService.showEverything();
		System.out.println("-----------------");
		orderManagementService.completeOrder(1);
		orderManagementService.showOrders();
		restaurantManagementService.showEverything();
		System.out.println("-----------------");
		restaurantManagementService.addFoodItemInMenu(1, new FoodItem(3, "Pasta", 150));
		orderManagementService.showOrders();
		restaurantManagementService.showEverything();
	}

}
