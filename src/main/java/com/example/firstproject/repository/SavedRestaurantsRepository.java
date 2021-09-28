package com.example.firstproject.repository;

import com.example.firstproject.model.SavedRestaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRestaurantsRepository extends JpaRepository<SavedRestaurants, Integer> {
    List<SavedRestaurants> findAllByUserId(String userId);
}
