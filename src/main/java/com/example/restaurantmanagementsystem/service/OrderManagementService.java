package com.example.restaurantmanagementsystem.service;

import com.example.restaurantmanagementsystem.factory.RestaurantFinderFactory;
import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.OrderStatus;
import com.example.restaurantmanagementsystem.model.Restaurant;
import com.example.restaurantmanagementsystem.model.RestaurantCriteria;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.order.OrderRepository;
import com.example.restaurantmanagementsystem.util.PriceCalculator;

import java.util.HashMap;
import java.util.List;

import static com.example.restaurantmanagementsystem.factory.RestaurantFinderFactory.getRestaurantFinder;

public class OrderManagementService {

    OrderRepository orderRepository;
    MenuRepository menuRepository;
    RestaurantFinderFactory restaurantFinderFactory;

    public OrderManagementService(OrderRepository orderRepository, MenuRepository menuRepository, RestaurantFinderFactory restaurantFinderFactory) {
        this.orderRepository = orderRepository;
        this.menuRepository = menuRepository;
        this.restaurantFinderFactory = restaurantFinderFactory;
    }

    public int placeOrder(String name, HashMap<FoodItem, Integer> foodItemsMap, RestaurantCriteria restaurantCriteria) {
        List<FoodItem> foodItems = PriceCalculator.convertFoodItemMapToList(foodItemsMap);
        Restaurant restaurant = getRestaurant(restaurantCriteria, foodItemsMap, foodItems);
        if (restaurant == null) {
            System.out.println("No restaurant found for the given criteria");
            return -1;
        }
        int orderId = orderRepository.placeOrder(name, restaurant.getId(), foodItems, restaurantCriteria,
                PriceCalculator.calculateTotalPrice(menuRepository.getMenu(restaurant.getMenuId()), foodItemsMap));
        System.out.println("Order placed successfully with order id: " + orderId);
        return orderId;
    }

    public Restaurant getRestaurant(RestaurantCriteria restaurantCriteria, HashMap<FoodItem, Integer> foodItemsMap, List<FoodItem> foodItems) {
        RestaurantFinder restaurantFinder = getRestaurantFinder(restaurantCriteria);
        return restaurantFinder.findRestaurant(foodItemsMap, foodItems);
    }

    public void completeOrder(int orderId) {
        orderRepository.updateOrder(orderId, OrderStatus.COMPLETED);
    }

    public void cancelOrder(int orderId) {
        orderRepository.updateOrder(orderId, OrderStatus.CANCELLED);
    }

    public void showOrders() {
        orderRepository.showOrders();
    }


}
