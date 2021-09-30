package com.example.firstproject.service;

import com.example.firstproject.model.ReviewComment;
import com.example.firstproject.repository.ReviewCommentRepository;
import com.example.firstproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ReviewCommentService {

    @Autowired
    ReviewCommentRepository reviewCommentRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public List<ReviewComment> getAllReviewComments() {
        List<ReviewComment> reviewComments = reviewCommentRepository.findAll();
        return reviewComments;
    }

    public List<ReviewComment> getReviewCommentsByReviewId(Integer reviewId) {
        List<ReviewComment> reviewComments = reviewCommentRepository.findAllByReviewId(reviewId);
        return reviewComments;
    }

    public ReviewComment registerReviewComment(Integer reviewId, ReviewComment reviewComment) {
        reviewComment.setReview(reviewRepository.getById(reviewId));
        reviewCommentRepository.save(reviewComment);
        return reviewComment;
    }

    public void modifyReviewComment(Integer reviewCommentId, ReviewComment reviewComment) {
        reviewCommentRepository.save(reviewComment);
    }

    public void removeReviewComment(Integer reviewCommentId) {
        reviewCommentRepository.deleteById(reviewCommentId);
    }
}
