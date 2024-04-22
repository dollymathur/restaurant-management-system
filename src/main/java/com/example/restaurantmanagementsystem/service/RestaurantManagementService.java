package com.example.restaurantmanagementsystem.service;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Menu;
import com.example.restaurantmanagementsystem.model.Restaurant;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;

import java.util.List;

public class RestaurantManagementService {

    RestaurantRepository restaurantRepository;
    MenuRepository menuRepository;

    public RestaurantManagementService(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    public void addMenu(int restaurantId, int menuId) {
        restaurantRepository.addMenuToRestaurant(restaurantId, menuId);
    }

    public void addFoodItemInMenu(int menuId, FoodItem foodItem) {
        menuRepository.addItemInMenu(menuId, foodItem);
    }

    public void addMenuToRestaurant(List<FoodItem> foodItems, int restaurantId) {
        int menuId = menuRepository.createMenu(foodItems);
        addMenu(restaurantId, menuId);
    }

    public void showEverything() {
        restaurantRepository.showRestaurants();
        menuRepository.showMenus();
    }

}
