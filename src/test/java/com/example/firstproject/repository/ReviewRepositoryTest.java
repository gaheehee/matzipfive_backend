package com.example.firstproject.repository;

import com.example.firstproject.model.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    /*@Test
    public void saveReviewTest(){

        // given
        final Review review = Review.builder()
                .userId("jghgahee")
                .reviewId(1)
                .content("yam")
                .createdAt("createdAt")
                .heartNum(0)
                .build();

        // when
        final Review savedReview = reviewRepository.save(review);

        // then
        assertEquals("jghgahee", savedReview.getUserId());
        assertEquals(1, savedReview.getReviewId());
        assertEquals("yam", savedReview.getContent());
        assertEquals("createdAt", savedReview.getCreatedAt());
        assertEquals(0, savedReview.getHeartNum());
    }*/
}
