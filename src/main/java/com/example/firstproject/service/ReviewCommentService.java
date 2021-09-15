package com.example.firstproject.service;

import com.example.firstproject.dao.ReviewCommentDao;
import com.example.firstproject.model.ReviewComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ReviewCommentService {

    @Autowired
    ReviewCommentDao reviewCommentDao;

    public List<ReviewComment> getAllReviewComments() {
        return reviewCommentDao.getAllReviewComments();
    }

    public List<ReviewComment> getReviewCommentsByReviewId(Integer reviewId) {
        return reviewCommentDao.getReviewCommentsByReviewId(reviewId);
    }

    public ReviewComment registerReviewComment(ReviewComment reviewComment) {
        return reviewCommentDao.insertReviewComment(reviewComment);
    }

    public void modifyReviewComment(Integer reviewCommentId, ReviewComment reviewComment) {
        reviewCommentDao.updateReviewComment(reviewCommentId, reviewComment);
    }

    public void removeReviewComment(Integer reviewCommentId) {
        reviewCommentDao.deleteReviewComment(reviewCommentId);
    }
}
