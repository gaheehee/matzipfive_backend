package com.example.firstproject.controller;

import com.example.firstproject.model.Review;
import com.example.firstproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/restaurantReviews/{restaurantId}")
    public List<Review> getAllReviewsByRestaurantId(@PathVariable Integer restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }

    @GetMapping("/myReviews/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable String userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    @PostMapping("/registration/{restaurantId}")
    public Review registerReview(@PathVariable Integer restaurantId, @RequestBody Review review) {
        return reviewService.registerReview(restaurantId, review);
    }

    @PutMapping("/{reviewId}")
    public void modifyReview(@PathVariable Integer reviewId, @RequestBody Review review) {
        reviewService.modifyReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public void removeReview(@PathVariable Integer reviewId) {
        reviewService.removeReview(reviewId);
    }

}
