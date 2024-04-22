package com.example.restaurantmanagementsystem.repository.menu;

import com.example.restaurantmanagementsystem.model.FoodItem;
import com.example.restaurantmanagementsystem.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    MenuInventory menuInventory = new MenuInventory();
    int id = 1;

    public void addMenu(Menu menu) {
        menu.setId(id);
        id++;
        menuInventory.menus.add(menu);
        return;
    }

    public void addItemInMenu(int menuId, FoodItem foodItem) {
        for (Menu menu : menuInventory.menus) {
            if (menu.getId() == menuId) {
                List<FoodItem> localFoodItems = new ArrayList<>(menu.getFoodItems());
                localFoodItems.add(foodItem);
                menu.setFoodItems(localFoodItems);
                System.out.println("FoodItem " + foodItem.getId() + " added successfully to menuId: " + menuId);
                break;
            }
        }
    }

    public void updateFoodItemPrice(int menuId, int foodItemId, double price) {
        for (Menu menu : menuInventory.menus) {
            if (menu.getId() == menuId) {
                for (FoodItem foodItem : menu.getFoodItems()) {
                    if (foodItem.getId() == foodItemId) {
                        foodItem.setPrice(price);
                        break;
                    }
                }
            }
        }
    }

    public Menu getMenu(int menuId) {
        for (Menu menu : menuInventory.menus) {
            if (menu.getId() == menuId) {
                return menu;
            }
        }
        return null;
    }

    public int createMenu(List<FoodItem> foodItems) {
        Menu menu = new Menu(id, foodItems);
        addMenu(menu);
        return menu.getId();
    }

    public void showMenus() {
        for (Menu menu : menuInventory.menus) {
            System.out.println(menu);
        }
    }
}
