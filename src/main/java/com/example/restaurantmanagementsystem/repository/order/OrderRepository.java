package com.example.restaurantmanagementsystem.repository.order;

import com.example.restaurantmanagementsystem.model.*;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;

import java.util.List;

public class OrderRepository {

    OrderInventory orderInventory = new OrderInventory();
    RestaurantRepository restaurantRepository;
    int id = 1;

    public OrderRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public int addOrder(Order order) {
        order.setId(id);
        order.setOrderStatus(OrderStatus.ACCEPTED);
        id++;
        orderInventory.orders.add(order);
        return id;
    }

    public void updateOrder(int id, OrderStatus orderStatus) {
        for (Order order : orderInventory.orders) {
            if (order.getId() == id) {
                if (orderStatus == OrderStatus.CANCELLED || OrderStatus.COMPLETED == orderStatus) {
                    System.out.println("Order with orderId: " + id + " successfully updated the status");
                    restaurantRepository.reduceRestaurantOrderCount(order.getRestaurantId());
                }
                order.setOrderStatus(orderStatus);
                return;
            }
        }
        System.out.println("Order with orderId: " + id + " not found");
    }

    public void reduceOrderCount(int restaurantId) {
        restaurantRepository.reduceRestaurantOrderCount(restaurantId);
    }

    public int placeOrder(String name, int restaurantId, List<FoodItem> foodItems, RestaurantCriteria restaurantCriteria, double totalPrice) {
        Order order = new Order(restaurantId, foodItems, totalPrice, restaurantCriteria,OrderStatus.INITIATED);
        restaurantRepository.updateRestaurantOrderCount(restaurantId);
        return addOrder(order);
    }

    public void showOrders() {
        for (Order order : orderInventory.orders) {
            System.out.println(order);
        }
    }
}
