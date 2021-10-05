package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecommentTest {

    @Test
    public void lombokTest() {
        // given
        Integer recommentId = 50;
        String userId = "gahee";
        String content = "dog is pretty";
        String createdAt = "yyyy'년' MM'월' dd'일', a hh:mm";

        // when
        Restaurant restaurant = new Restaurant(30, "ice cream");
        Review review = new Review(1, "gahee", "wow", 5, "createdAt");
        review.setRestaurant(restaurant);
        ReviewComment reviewComment = new ReviewComment(1, "gahee", "content", "createdAt");
        reviewComment.setReview(review);
        Recomment recomment = new Recomment(recommentId, userId, content, createdAt);
        recomment.setReviewComment(reviewComment);

        // then
        assertThat(recomment.getRecommentId()).isEqualTo(recommentId);
        assertThat(recomment.getUserId()).isEqualTo(userId);
        assertThat(recomment.getContent()).isEqualTo(content);
        assertThat(recomment.getCreatedAt()).isEqualTo(createdAt);
        assertThat(recomment.getReviewComment()).isEqualTo(reviewComment);
    }
}
