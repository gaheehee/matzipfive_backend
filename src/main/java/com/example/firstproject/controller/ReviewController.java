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

    // 모든 review 가져오기
    @GetMapping("")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // 특정 맛집에 달린 리뷰들 가져오기
    @GetMapping("/restaurantReviews/{restaurantId}")
    public List<Review> getAllReviewsByRestaurantId(@PathVariable Integer restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }

    // 특정 user가 작성한 리뷰들 가져오기
    @GetMapping("/myReviews/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable String userId) {
        return reviewService.getReviewsByUserId(userId);
    }

    // 특정 맛집에 리뷰 달기(리뷰 등록)
    @PostMapping("/registration/{restaurantId}")
    public Review registerReview(@PathVariable Integer restaurantId, @RequestBody Review review) {
        return reviewService.registerReview(restaurantId, review);
    }

    // 특정 리뷰 수정하기
    @PutMapping("/{reviewId}")
    public void modifyReview(@PathVariable Integer reviewId, @RequestBody Review review) {
        reviewService.modifyReview(reviewId, review);
    }

    // 특정 리뷰 삭제
    // 리뷰 지워지면, 리뷰에 달린 대대댓글들 다 지워지게 만듦!
    @DeleteMapping("/{reviewId}")
    public void removeReview(@PathVariable Integer reviewId) {
        reviewService.removeReview(reviewId);
    }

}
