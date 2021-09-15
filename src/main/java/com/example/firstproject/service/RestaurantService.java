package com.example.firstproject.service;

import com.example.firstproject.dao.RestaurantDao;
import com.example.firstproject.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RestaurantService {

    @Autowired
    RestaurantDao restaurantDao;

    public Restaurant getRestaurantNameByRestaurantId(Integer restaurantId) {
        return restaurantDao.getRestaurantNameByRestaurantId(restaurantId);
    }
}
