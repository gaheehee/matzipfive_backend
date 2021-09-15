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

    @GetMapping("/{restaurantId}")
    public List<Review> getAllReviewsByRestaurantId(@PathVariable Integer restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }

    @GetMapping("/{restaurantId}/{reviewId}/{userNo}")
    public List<Review> getReviewsByUserNo(@PathVariable Integer userNo) {
        return reviewService.getReviewsByUserNo(userNo);
    }

    @PostMapping("")
    public Review registerReview(@RequestBody Review review) {
        return reviewService.registerReview(review);
    }

    @PutMapping("/{restaurantId}/{reviewId}")
    public void modifyReview(@PathVariable Integer reviewId, @RequestBody Review review) {
        reviewService.modifyReview(reviewId, review);
    }

    @DeleteMapping("/{restaurantId}/{reviewId}")
    public void removeReview(@PathVariable Integer reviewId) {
        reviewService.removeReview(reviewId);
    }

}
