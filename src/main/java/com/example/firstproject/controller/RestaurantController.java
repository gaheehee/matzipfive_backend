package com.example.firstproject.controller;

import com.example.firstproject.model.Restaurant;
import com.example.firstproject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantByRestaurantId(@PathVariable Integer restaurantId) {
        return restaurantService.getRestaurantByRestaurantId(restaurantId);
    }
}
