package com.example.firstproject.service;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.model.ReviewComment;
import com.example.firstproject.repository.RecommentRepository;
import com.example.firstproject.repository.ReviewCommentRepository;
import com.example.firstproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReviewCommentService {

    @Autowired
    ReviewCommentRepository reviewCommentRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RecommentRepository recommentRepository;


    public List<ReviewComment> getAllReviewComments() {
        List<ReviewComment> reviewComments = reviewCommentRepository.findAll();
        return reviewComments;
    }

    public List<ReviewComment> getReviewCommentsByReviewId(Integer reviewId) {
        List<ReviewComment> reviewComments = reviewCommentRepository
                .findAllByReview(reviewRepository.getById(reviewId));
        return reviewComments;
    }

    public ReviewComment registerReviewComment(Integer reviewId, ReviewComment reviewComment) {
        reviewComment.setReview(reviewRepository.getById(reviewId));
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        reviewComment.createdAt = timeStamp;
        reviewCommentRepository.save(reviewComment);
        return reviewComment;
    }

    public void modifyReviewComment(ReviewComment reviewComment) {
        reviewCommentRepository.save(reviewComment);
    }

    public void removeReviewComment(Integer reviewCommentId) {
        List<Recomment> recommentList = recommentRepository
                .findByReviewComment(reviewCommentRepository.findById(reviewCommentId));

        Recomment temp;

        for(int i=0; i < recommentList.size(); i++){
            temp = recommentList.get(i);
            recommentRepository.deleteById(temp.getRecommentId());
        }
        reviewCommentRepository.deleteById(reviewCommentId);
    }
}
