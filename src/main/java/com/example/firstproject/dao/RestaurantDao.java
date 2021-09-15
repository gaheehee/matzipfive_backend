package com.example.firstproject.dao;

import com.example.firstproject.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {

    public static List<Restaurant> restaurants;

    static{
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1,"피자브라더스"));
        restaurants.add(new Restaurant(2,"엽떡"));
        restaurants.add(new Restaurant(3,"두찜"));
    }

    public Restaurant getRestaurantNameByRestaurantId(Integer restaurantId) {
        return restaurants
                .stream()
                .filter(restaurant -> restaurant.getRestaurantId().equals(restaurantId))
                .findAny()
                .orElse(new Restaurant(-1,""));
    }
}
