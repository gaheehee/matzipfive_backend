package com.example.firstproject.dao;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ReviewDao {

    public List<Review> MockReviews = new ArrayList<>();

    {
        MockReviews.add(new Review(1,1,"userId1","너무 맛있어용",4,"2021년 09월 16일, 오후 02:17"));
        MockReviews.add(new Review(2,2,"userId2","굿",4,"2021년 09월 16일, 오후 02:17"));
        MockReviews.add(new Review(1,3,"userId3","짱",4,"2021년 09월 16일, 오후 02:17"));
        MockReviews.add(new Review(2,4,"userId4","JMT",4,"2021년 09월 16일, 오후 02:17"));

    }

    public List<Review> getAllReviews() {
        return MockReviews;
    }

    public List<Review> getReviewsByRestaurantId(Integer restaurantId) {

        List<Review> reviewList = MockReviews.stream() .filter(review -> review.getRestaurantId().equals(restaurantId)) .collect(Collectors.toList());

        return reviewList;

        /*return reviews
                .stream()
                .filter(review -> review.getRestaurantId().equals(restaurantId))
                .findAny()
                .orElse(new Review(-1,-1,-1,"",-1,""));*/
    }

    public List<Review> getReviewsByUserId(String userId) {

        List<Review> reviewList = MockReviews.stream() .filter(review -> review.getUserId().equals(userId)) .collect(Collectors.toList());

        return reviewList;

        /*return reviews
                .stream()
                .filter(review -> review.getUserNo().equals(userNo))
                .findAny()
                .orElse(new Review(-1,-1,-1,"",-1,""));*/
    }

    public Review insertReview(Review review) {

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        review.createdAt = timeStamp;

        MockReviews.add(review);
        return review;
    }

    public void updateReview(Integer reviewId, Review review) {
        // 리뷰글 내용 업뎃
        MockReviews.stream()
                .filter(curReview -> curReview.getReviewId().equals(reviewId))
                .findAny()
                .orElse(new Review(-1,-1,"","",-1,""))
                .setContent(review.getContent());

        // 리뷰글 수정날짜 업뎃
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);
        review.createdAt = timeStamp;

        MockReviews.stream()
                .filter(curRecomment -> curRecomment.getReviewId().equals(reviewId))
                .findAny()
                .orElse(new Review(-1,-1,"","",-1,""))
                .setCreatedAt(review.getCreatedAt());

        // 리뷰 하트 수 없뎃
        MockReviews.stream()
                .filter(curReview -> curReview.getReviewId().equals(reviewId))
                .findAny()
                .orElse(new Review(-1,-1,"","",-1,""))
                .setHeart_num(review.getHeart_num());

    }

    public void deleteReview(Integer reviewId) {
        MockReviews.removeIf(review -> review.getReviewId().equals(reviewId));
    }
}
