package com.example.firstproject.controller;

import com.example.firstproject.model.ReviewComment;
import com.example.firstproject.service.ReviewCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviewComments")
public class ReviewCommentController {

    @Autowired
    ReviewCommentService reviewCommentService;

    @GetMapping("")
    public List<ReviewComment> getAllReviewComments() {
        return reviewCommentService.getAllReviewComments();
    }

    // 해당 리뷰에 달린 reviewComment들 가져오기
    @GetMapping("/reviewCommentsInReview/{reviewId}")
    public List<ReviewComment> getReviewCommentsByReviewId(@PathVariable Integer reviewId) {
        return reviewCommentService.getReviewCommentsByReviewId(reviewId);
    }

    @PostMapping("/registration/{reviewId}")
    public ReviewComment registerReviewComment(@PathVariable Integer reviewId, @RequestBody ReviewComment reviewComment) {
        return reviewCommentService.registerReviewComment(reviewId, reviewComment);
    }

    @PutMapping("/{reviewCommentId}")
    public void modifyReviewComment(@PathVariable Integer reviewCommentId, @RequestBody ReviewComment reviewComment) {
        reviewCommentService.modifyReviewComment(reviewCommentId, reviewComment);
    }

    // reviewComment 지워지면 해당 reviewComment 밑에 있는 recomment들도 지워져야함
    @DeleteMapping("/{reviewCommentId}")
    public void removeReviewComment(@PathVariable Integer reviewCommentId) {
        reviewCommentService.removeReviewComment(reviewCommentId);
    }

}
