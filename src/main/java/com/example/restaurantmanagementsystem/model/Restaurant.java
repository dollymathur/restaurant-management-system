package com.example.restaurantmanagementsystem.model;

public class Restaurant {
    int id;
    int rating;
    String name;
    int maxOrder;
    int orderCount;
    int menuId;

    public Restaurant(int id, int rating, String name, int maxOrder, int menuId, int i) {
        this.id = id;
        this.rating = rating;
        this.name = name;
        this.maxOrder = maxOrder;
        this.orderCount = 0;
        this.menuId = menuId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxOrder() {
        return maxOrder;
    }

    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", maxOrder=" + maxOrder +
                ", orderCount=" + orderCount +
                ", menuId=" + menuId +
                '}';
    }
}
