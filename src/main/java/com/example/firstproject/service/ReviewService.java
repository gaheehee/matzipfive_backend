package com.example.firstproject.service;

import com.example.firstproject.dao.ReviewDao;
import com.example.firstproject.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;

    public List<Review> getAllReviews(){
        return reviewDao.getAllReviews();
    }

    public List<Review> getReviewsByRestaurantId(Integer restaurantId) {
        return reviewDao.getReviewsByRestaurantId(restaurantId);
    }

    public List<Review> getReviewsByUserId(String userId) {
        return reviewDao.getReviewsByUserId(userId);
    }

    public Review registerReview(Review review) {
        return reviewDao.insertReview(review);
    }

    public void modifyReview(Integer reviewId, Review review) {
        reviewDao.updateReview(reviewId, review);
    }

    public void removeReview(Integer reviewId) {
        reviewDao.deleteReview(reviewId);
    }

}
