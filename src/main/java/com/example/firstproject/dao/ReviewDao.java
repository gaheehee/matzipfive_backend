package com.example.firstproject.dao;

import com.example.firstproject.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ReviewDao {

    public static List<Review> reviews;

    static{
        reviews = new ArrayList<>();
        reviews.add(new Review(1,1,34,"너무 맛있어용",4,"2021년 8월 17일 1:56 PM"));
        reviews.add(new Review(2,2,34,"굿",4,"2018년 5월 17일 1:56 PM"));
        reviews.add(new Review(1,3,6,"짱",4,"2006년 4월 17일 1:56 PM"));
        reviews.add(new Review(2,4,8,"JMT",4,"2020년 3월 17일 1:56 PM"));

    }

    public List<Review> getAllReviews() {
        return reviews;
    }

    public List<Review> getReviewsByRestaurantId(Integer restaurantId) {

        List<Review> reviewList = reviews.stream() .filter(review -> review.getRestaurantId().equals(restaurantId)) .collect(Collectors.toList());

        return reviewList;

        /*return reviews
                .stream()
                .filter(review -> review.getRestaurantId().equals(restaurantId))
                .findAny()
                .orElse(new Review(-1,-1,-1,"",-1,""));*/
    }

    public List<Review> getReviewsByUserNo(Integer userNo) {

        List<Review> reviewList = reviews.stream() .filter(review -> review.getUserNo().equals(userNo)) .collect(Collectors.toList());

        return reviewList;

        /*return reviews
                .stream()
                .filter(review -> review.getUserNo().equals(userNo))
                .findAny()
                .orElse(new Review(-1,-1,-1,"",-1,""));*/
    }

    public Review insertReview(Review review) {
        reviews.add(review);
        return review;
    }

    public void updateReview(Integer reviewId, Review review) {
        reviews.stream()
                .filter(curReview -> curReview.getReviewId().equals(reviewId))
                .findAny()
                .orElse(new Review(-1,-1,-1,"",-1,""))
                .setContent(review.getContent());
    }

    public void deleteReview(Integer reviewId) {
        reviews.removeIf(review -> review.getReviewId().equals(reviewId));
    }
}
