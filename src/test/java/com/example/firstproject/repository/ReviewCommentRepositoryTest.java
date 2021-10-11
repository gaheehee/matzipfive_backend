package com.example.firstproject.repository;

import com.example.firstproject.model.ReviewComment;
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
public class ReviewCommentRepositoryTest {

    @Autowired
    private ReviewCommentRepository reviewCommentRepository;

    @Test
    public void saveReviewCommentTest(){

        // given
        final ReviewComment reviewComment = ReviewComment.builder()
                .userId("jghgahee")
                .content("bb")
                .createdAt("createdAt")
                .build();

        // when
        final ReviewComment savedReviewComment = reviewCommentRepository.save(reviewComment);

        // then
        assertEquals("jghgahee", savedReviewComment.getUserId());
        assertEquals("bb",savedReviewComment.getContent());
        assertEquals("createdAt", savedReviewComment.getCreatedAt());

    }
}
