package com.example.restaurantmanagementsystem.factory;

import com.example.restaurantmanagementsystem.model.RestaurantCriteria;
import com.example.restaurantmanagementsystem.repository.menu.MenuRepository;
import com.example.restaurantmanagementsystem.repository.restaurant.RestaurantRepository;
import com.example.restaurantmanagementsystem.service.HighestRatingRestaurantFinder;
import com.example.restaurantmanagementsystem.service.LowestPriceRestaurantFinder;
import com.example.restaurantmanagementsystem.service.RestaurantFinder;

public class RestaurantFinderFactory {

    static MenuRepository menuRepository;
    static RestaurantRepository restaurantRepository;

    public RestaurantFinderFactory(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        RestaurantFinderFactory.menuRepository = menuRepository;
        RestaurantFinderFactory.restaurantRepository = restaurantRepository;
    }

    public static RestaurantFinder getRestaurantFinder(RestaurantCriteria restaurantType) {
        if (restaurantType == null) {
            return null;
        }
        if (restaurantType == RestaurantCriteria.HIGHEST_RATING) {
            return new HighestRatingRestaurantFinder(menuRepository, restaurantRepository);
        } else if (restaurantType == RestaurantCriteria.LOWEST_COST) {
            return new LowestPriceRestaurantFinder(menuRepository, restaurantRepository);
        }
        return null;
    }

}
