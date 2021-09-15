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

    @GetMapping("/{reviewId}")
    public List<ReviewComment> getReviewCommentsByReviewId(@PathVariable Integer reviewId) {
        return reviewCommentService.getReviewCommentsByReviewId(reviewId);
    }

    @PostMapping("")
    public ReviewComment registerReviewComment(@RequestBody ReviewComment reviewComment) {
        return reviewCommentService.registerReviewComment(reviewComment);
    }

    @PutMapping("/{reviewId}/{reviewCommentId}")
    public void modifyReviewComment(@PathVariable Integer reviewCommentId, @RequestBody ReviewComment reviewComment) {
        reviewCommentService.modifyReviewComment(reviewCommentId, reviewComment);
    }

    @DeleteMapping("/{reviewId}/{reviewCommentId}")
    public void removeReviewComment(@PathVariable Integer reviewCommentId) {
        reviewCommentService.removeReviewComment(reviewCommentId);
    }

}
