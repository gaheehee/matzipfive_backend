package com.example.firstproject.repository;

import com.example.firstproject.model.Review;
import com.example.firstproject.model.ReviewComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, Integer> {

    List<ReviewComment> findAllByReview(Review byId);

    List<ReviewComment> findByReview(Optional<Review> byId);
}
