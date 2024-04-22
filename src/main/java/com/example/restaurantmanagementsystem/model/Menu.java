package com.example.restaurantmanagementsystem.model;

import java.util.List;

public class Menu {
    int id;
    List<FoodItem> foodItems;

    public Menu(int id, List<FoodItem> foodItems) {
        this.id = id;
        this.foodItems = foodItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", foodItems=" + foodItems +
                '}';
    }
}
