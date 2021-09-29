package com.example.firstproject.service;

import com.example.firstproject.model.Review;
import com.example.firstproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews;
    }

    public List<Review> getReviewsByRestaurantId(Integer restaurantId) {
        List<Review> reviews = reviewRepository.findAllByRestaurantId(restaurantId);
        return reviews;
    }

    public List<Review> getReviewsByUserId(String userId) {
        List<Review> reviews = reviewRepository.findAllByUserId(userId);
        return reviews;
    }

    public Review registerReview(Review review) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        review.createdAt = timeStamp;
        reviewRepository.save(review);
        return review;
    }

    public void modifyReview(Integer reviewId, Review review) {
        reviewRepository.save(review);
    }

    public void removeReview(Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
