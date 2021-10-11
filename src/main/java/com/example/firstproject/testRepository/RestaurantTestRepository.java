package com.example.firstproject.testRepository;

import com.example.firstproject.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTestRepository extends JpaRepository<Restaurant, Integer> {
}
