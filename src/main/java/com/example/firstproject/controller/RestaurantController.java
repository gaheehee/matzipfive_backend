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

    // 모든 restaurant 정보 가져오기
    @GetMapping("")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    // 특정 restaurant 정보 가져오기
    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurantByRestaurantId(@PathVariable Integer restaurantId) {
        return restaurantService.getRestaurantByRestaurantId(restaurantId);
    }

    // 해당 card 안의 맛집들 정보 가져오기
    @GetMapping("/InCard/{cardId}")
    public List<Restaurant> getRestaurantsByCardId(@PathVariable Integer cardId){
        return restaurantService.getRestaurantByCardId(cardId);
    }

}
