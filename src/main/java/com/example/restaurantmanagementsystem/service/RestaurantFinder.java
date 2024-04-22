package com.example.restaurantmanagementsystem.service;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Menu;
import com.example.restaurantmanagementsystem.model.Restaurant;

import java.util.HashMap;
import java.util.List;

public interface RestaurantFinder {
    Restaurant findRestaurant(HashMap<FoodItem, Integer> foodItemsMap, List<FoodItem> foodItems);

    default boolean checkIfAllFoodItemsPresent(List<FoodItem> foodItems, Menu menu) {
        for (FoodItem foodItem : foodItems) {
            boolean found = false;
            for (FoodItem item : menu.getFoodItems()) {
                if (item.getId() == foodItem.getId()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
