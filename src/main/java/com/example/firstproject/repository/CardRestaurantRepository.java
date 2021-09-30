package com.example.firstproject.repository;

import com.example.firstproject.model.CardRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRestaurantRepository extends JpaRepository<CardRestaurant, Integer> {

    void deleteByCardIdAndRestaurantId(Integer cardId, Integer restaurantId);
}
