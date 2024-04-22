package com.example.restaurantmanagementsystem.service;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Restaurant;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;

import java.util.HashMap;
import java.util.List;

public class HighestRatingRestaurantFinder implements RestaurantFinder {

    MenuRepository menuRepository;
    RestaurantRepository restaurantRepository;

    public HighestRatingRestaurantFinder(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant findRestaurant(HashMap<FoodItem, Integer> foodItemsMap, List<FoodItem> foodItems) {
        int rating = 0;
        Restaurant desiredRestaurant = null;
        for (Restaurant restaurant : restaurantRepository.getRestaurants()) {
            if (restaurant.getRating() > rating &&
                    checkIfAllFoodItemsPresent(foodItems, menuRepository.getMenu(restaurant.getMenuId())) &&
                    restaurant.getMaxOrder() > restaurant.getOrderCount()) {
                rating = restaurant.getRating();
                desiredRestaurant = restaurant;
            }
        }
        return desiredRestaurant;
    }
}
