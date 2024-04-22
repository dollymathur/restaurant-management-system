package com.example.restaurantmanagementsystem.model;

import java.util.List;

public class Order {
    int id;
    int restaurantId;
    List<FoodItem> foodItems;
    double totalPrice;
    RestaurantCriteria restaurantCriteria;
    OrderStatus orderStatus;

    public Order(int restaurantId, List<FoodItem> foodItems, double totalPrice, RestaurantCriteria restaurantCriteria, OrderStatus orderStatus) {
        this.restaurantId = restaurantId;
        this.foodItems = foodItems;
        this.totalPrice = totalPrice;
        this.restaurantCriteria = restaurantCriteria;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public RestaurantCriteria getRestaurantCriteria() {
        return restaurantCriteria;
    }

    public void setRestaurantCriteria(RestaurantCriteria restaurantCriteria) {
        this.restaurantCriteria = restaurantCriteria;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", foodItems=" + foodItems +
                ", totalPrice=" + totalPrice +
                ", restaurantCriteria=" + restaurantCriteria +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
