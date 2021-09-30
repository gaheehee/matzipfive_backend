package com.example.firstproject.repository;

import com.example.firstproject.model.UserSavedRestaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserSavedRestaurantsRepository extends JpaRepository<UserSavedRestaurants, Integer> {

    List<UserSavedRestaurants> findAllByUserId(String userId);

    @Transactional
    void deleteByUserIdAndRestaurantId(String userId, Integer restaurantId);
}
