package com.example.firstproject.dao;

import com.example.firstproject.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {

    public List<Restaurant> MockRestaurants = new ArrayList<>();

    {
        MockRestaurants.add(new Restaurant(1,"피자브라더스"));
        MockRestaurants.add(new Restaurant(2,"엽떡"));
        MockRestaurants.add(new Restaurant(3,"두찜"));
    }

    public Restaurant getRestaurantNameByRestaurantId(Integer restaurantId) {
        return MockRestaurants
                .stream()
                .filter(restaurant -> restaurant.getRestaurantId().equals(restaurantId))
                .findAny()
                .orElse(new Restaurant(-1,""));
    }
}
