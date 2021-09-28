package com.example.firstproject.service;

import com.example.firstproject.model.Restaurant;
import com.example.firstproject.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurantByRestaurantId(Integer restaurantId) {
        return restaurantRepository.getById(restaurantId);
    }
}
