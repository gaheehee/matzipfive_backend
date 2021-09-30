package com.example.firstproject.repository;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.CardRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CardRestaurantRepository extends JpaRepository<CardRestaurant, Integer> {

    void deleteByCardAndRestaurantId(Card byId, Integer restaurantId);
}
