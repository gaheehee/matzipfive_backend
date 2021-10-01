package com.example.firstproject.service;

import com.example.firstproject.model.CardRestaurant;
import com.example.firstproject.model.Restaurant;
import com.example.firstproject.repository.CardRestaurantRepository;
import com.example.firstproject.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    // 해당 카드 안의 맛집 가져오기
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
