package com.example.firstproject.repository;

import com.example.firstproject.model.CardRestaurantIds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRestaurantIdsRepository extends JpaRepository<CardRestaurantIds, Integer> {
    List<CardRestaurantIds> findAllByCardId(Integer cardId);
}
