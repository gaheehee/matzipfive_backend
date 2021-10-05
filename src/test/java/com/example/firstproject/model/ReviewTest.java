package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewTest {

    @Test
    public void lombokTest() {
        // given
        Integer reviewId = 15;
        String userId = "gahee";
        String content = "i want to see mugical now";
        Integer heartNum = 10;
        String createdAt = "yyyy'년' MM'월' dd'일', a hh:mm";

        // when
        Restaurant restaurant = new Restaurant(30, "ice cream");
        Review review = new Review(reviewId, userId, content, heartNum, createdAt);
        review.setRestaurant(restaurant);

        // then
        assertThat(review.getReviewId()).isEqualTo(reviewId);
        assertThat(review.getUserId()).isEqualTo(userId);
        assertThat(review.getContent()).isEqualTo(content);
        assertThat(review.getHeartNum()).isEqualTo(heartNum);
        assertThat(review.getCreatedAt()).isEqualTo(createdAt);
        assertThat(review.getRestaurant()).isEqualTo(restaurant);
    }
}
