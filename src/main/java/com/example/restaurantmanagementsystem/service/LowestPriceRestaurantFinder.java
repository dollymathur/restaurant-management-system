package com.example.restaurantmanagementsystem.service;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Menu;
import com.example.restaurantmanagementsystem.model.Restaurant;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;
import com.example.restaurantmanagementsystem.util.PriceCalculator;

import java.util.HashMap;
import java.util.List;

public class LowestPriceRestaurantFinder implements RestaurantFinder {

    MenuRepository menuRepository;
    RestaurantRepository restaurantRepository;

    public LowestPriceRestaurantFinder(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant findRestaurant(HashMap<FoodItem, Integer> foodItemsMap, List<FoodItem> foodItems) {
        double price = Double.MAX_VALUE;
        Restaurant desiredRestaurant = null;
        for (Restaurant restaurant : restaurantRepository.getRestaurants()) {
            if (checkIfAllFoodItemsPresent(foodItems, menuRepository.getMenu(restaurant.getMenuId())) &&
                    restaurant.getMaxOrder() > restaurant.getOrderCount()) {
                Menu menu = menuRepository.getMenu(restaurant.getMenuId());
                double totalPrice = PriceCalculator.calculateTotalPrice(menu, foodItemsMap);

                if (totalPrice <= price) {
                    price = totalPrice;
                    desiredRestaurant = restaurant;
                }
            }
        }
        return desiredRestaurant;
    }
}
