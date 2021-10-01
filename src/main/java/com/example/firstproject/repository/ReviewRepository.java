package com.example.firstproject.repository;

import com.example.firstproject.model.Restaurant;
import com.example.firstproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAllByUserId(String userId);

    List<Review> findAllByRestaurant(Restaurant byId);

    Review findByReviewId(Integer reviewId);
}
