package com.example.firstproject.repository;

import com.example.firstproject.model.CardRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
public interface CardRestaurantRepository extends JpaRepository<CardRestaurant, Integer> {

    @Transactional
    void deleteByCardIdAndRestaurantId(Integer cardId, Integer restaurantId);

    @Transactional
    void deleteByCardId(Integer cardId);

    List<CardRestaurant> findAllByCardId(Integer cardId);
}
