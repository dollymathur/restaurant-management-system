package com.example.restaurantmanagementsystem.util;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PriceCalculator {

    public static double calculateTotalPrice(Menu menu, Map<FoodItem, Integer> foodItemMap) {
        double totalPrice = 0;

        for (Map.Entry<FoodItem, Integer> entry : foodItemMap.entrySet()) {
            FoodItem foodItem = entry.getKey();
            for (FoodItem f : menu.getFoodItems()) {
                if (Objects.equals(f.getName(), foodItem.getName())) {
                    totalPrice += f.getPrice() * entry.getValue();
                    break;
                }
            }
        }
        return totalPrice;
    }

    public static List<FoodItem> convertFoodItemMapToList(Map<FoodItem, Integer> foodItemMap) {
        List<FoodItem> foodItems = new ArrayList<>();
        for (Map.Entry<FoodItem, Integer> entry : foodItemMap.entrySet()) {
            FoodItem foodItem = entry.getKey();
            foodItems.add(foodItem);
        }
        return foodItems;
    }
}
