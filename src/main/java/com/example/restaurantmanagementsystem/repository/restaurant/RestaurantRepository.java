package com.example.restaurantmanagementsystem.repository.restaurant;

import com.example.restaurantmanagementsystem.model.Restaurant;

import java.util.List;

public class RestaurantRepository {

    RestaurantInventory restaurantInventory = new RestaurantInventory();

    public void addRestaurant(Restaurant restaurant) {
        restaurantInventory.restaurants.add(restaurant);
        System.out.println("Restaurant " + restaurant.getId() + " added successfully");
    }

    public void addMenuToRestaurant(int restaurantId, int menuId) {
        for (Restaurant restaurant : restaurantInventory.restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.setMenuId(menuId);
                System.out.println("Menu with menuId: " + menuId + " added successfully to restaurantId: " + restaurantId);
                return;
            }
        }
    }

    public List<Restaurant> getRestaurants() {
        return restaurantInventory.restaurants;
    }

    public void updateRestaurantOrderCount(int restaurantId) {
        for (Restaurant restaurant : restaurantInventory.restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.setOrderCount(restaurant.getOrderCount() + 1);
            }
        }
    }

    public void reduceRestaurantOrderCount(int restaurantId) {
        for (Restaurant restaurant : restaurantInventory.restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.setOrderCount(restaurant.getOrderCount() - 1);
            }
        }
    }

    public void showRestaurants() {
        for (Restaurant restaurant : restaurantInventory.restaurants) {
            System.out.println(restaurant);
        }
    }

}
