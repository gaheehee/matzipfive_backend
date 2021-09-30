package com.example.firstproject.controller;

import com.example.firstproject.model.Restaurant;
import com.example.firstproject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
