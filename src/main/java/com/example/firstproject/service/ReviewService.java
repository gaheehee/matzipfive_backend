package com.example.firstproject.service;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.model.Review;
import com.example.firstproject.model.ReviewComment;
import com.example.firstproject.repository.RecommentRepository;
import com.example.firstproject.repository.RestaurantRepository;
import com.example.firstproject.repository.ReviewCommentRepository;
import com.example.firstproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ReviewCommentRepository reviewCommentRepository;
    @Autowired
    RecommentRepository recommentRepository;


    public List<Review> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews;
    }

    public List<Review> getReviewsByRestaurantId(Integer restaurantId) {
        List<Review> reviews = reviewRepository
                .findAllByRestaurant(restaurantRepository.getById(restaurantId));
        return reviews;
    }

    public List<Review> getReviewsByUserId(String userId) {
        List<Review> reviews = reviewRepository.findAllByUserId(userId);
        return reviews;
    }

    public Review registerReview(Integer restaurantId, Review review) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        review.createdAt = timeStamp;
        review.setRestaurant(restaurantRepository.getById(restaurantId));

        reviewRepository.save(review);
        return review;
    }

    public void modifyReview(Integer reviewId, Review review) {
        reviewRepository.save(review);
    }

    public void removeReview(Integer reviewId) {
        List<ReviewComment> reviewCommentList = reviewCommentRepository
                .findByReview(reviewRepository.findById(reviewId));

        ReviewComment tempReviewComment = new ReviewComment();
        Integer reviewCommentId;

        for(int i=0; i < reviewCommentList.size(); i++){
            tempReviewComment = reviewCommentList.get(i);
            reviewCommentId = tempReviewComment.getReviewCommentId();

            List<Recomment> recommentList = recommentRepository
                    .findByReviewComment(reviewCommentRepository.findById(reviewCommentId));

            Recomment temp = new Recomment();

            for(int j=0; j < recommentList.size(); j++){
                temp = recommentList.get(i);
                recommentRepository.deleteById(temp.getRecommentId());
            }
            reviewCommentRepository.deleteById(reviewCommentId);
            recommentList.clear();
        }
        reviewRepository.deleteById(reviewId);
    }

}
