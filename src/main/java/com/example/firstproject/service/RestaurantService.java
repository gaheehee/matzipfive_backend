package com.example.firstproject.service;

import com.example.firstproject.model.CardRestaurant;
import com.example.firstproject.model.Restaurant;
import com.example.firstproject.repository.CardRestaurantRepository;
import com.example.firstproject.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    CardRestaurantRepository cardRestaurantRepository;


    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurantByRestaurantId(Integer restaurantId) {
        return restaurantRepository.getById(restaurantId);
    }

    public List<Restaurant> getRestaurantByCardId(Integer cardId) {
        List<CardRestaurant> cardRestaurants = cardRestaurantRepository.findAllByCardId(cardId);
        List<Integer> restaurantIdsList = new ArrayList<>();
        CardRestaurant temp;

        for(int i=0; i < cardRestaurants.size(); i++){
            temp = cardRestaurants.get(i);
            restaurantIdsList.add(temp.getRestaurantId());
        }

        List<Restaurant> restaurants = new ArrayList<>();

        for(int i=0; i < restaurantIdsList.size(); i++){
            restaurants.add(restaurantRepository.getById(restaurantIdsList.get(i)));
        }
        return restaurants;
    }
}
