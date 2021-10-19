package com.example.firstproject.repository;

import com.example.firstproject.model.UserHeartReview;
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
public class UserHeartReviewRepositoryTest {

    @Autowired
    private UserHeartReviewRepository userHeartReviewRepository;

    /*@Test
    public void saveUserHeartReviewTest() {

        // given
        final UserHeartReview userHeartReview = UserHeartReview.builder()
                .userId("jghgahee")
                .reviewId(1)
                .build();

        // when
        final UserHeartReview savedUserHeartReview = userHeartReviewRepository.save(userHeartReview);

        // then
        assertEquals("jghgahee", savedUserHeartReview.getUserId());
        assertEquals(1, savedUserHeartReview.getReviewId());
    }*/
}
