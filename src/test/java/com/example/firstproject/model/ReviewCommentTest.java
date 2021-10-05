package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReviewCommentTest {

    @Test
    public void lombokTest() {
        // given
        Integer reviewCommentId = 42;
        String userId = "gahee";
        String content = "cat is lovely.";
        String createdAt = "yyyy'년' MM'월' dd'일', a hh:mm";

        // when
        Restaurant restaurant = new Restaurant(30, "ice cream");
        Review review = new Review(1, "gahee", "wow", 5, "createdAt");
        review.setRestaurant(restaurant);
        ReviewComment reviewComment = new ReviewComment(reviewCommentId, userId, content, createdAt);
        reviewComment.setReview(review);

        // then
        assertThat(reviewComment.getReviewCommentId()).isEqualTo(reviewCommentId);
        assertThat(reviewComment.getUserId()).isEqualTo(userId);
        assertThat(reviewComment.getContent()).isEqualTo(content);
        assertThat(reviewComment.getCreatedAt()).isEqualTo(createdAt);
        assertThat(reviewComment.getReview()).isEqualTo(review);
    }
}
