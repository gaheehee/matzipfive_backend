package com.example.firstproject.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class UserHeartReviewTest {

    @Test
    public void lombokTest() {
        // given
        Integer id = 5;
        String userId = "gahee";
        Integer reviewId = 10;

        // when
        UserHeartReview userHeartReview = new UserHeartReview(id, userId, reviewId);

        // then
        assertThat(userHeartReview.getId()).isEqualTo(id);
        assertThat(userHeartReview.getUserId()).isEqualTo(userId);
        assertThat(userHeartReview.getReviewId()).isEqualTo(reviewId);
    }
}
