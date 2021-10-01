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

    // 모든 reviewComment 정보 가져오기
    @GetMapping("")
    public List<ReviewComment> getAllReviewComments() {
        return reviewCommentService.getAllReviewComments();
    }

    // 특정 리뷰에 달린 reviewComment들 가져오기
    @GetMapping("/reviewCommentsInReview/{reviewId}")
    public List<ReviewComment> getReviewCommentsByReviewId(@PathVariable Integer reviewId) {
        return reviewCommentService.getReviewCommentsByReviewId(reviewId);
    }

    // 특정 review에 reviewComment 달기(등록)
    @PostMapping("/registration/{reviewId}")
    public ReviewComment registerReviewComment(@PathVariable Integer reviewId, @RequestBody ReviewComment reviewComment) {
        return reviewCommentService.registerReviewComment(reviewId, reviewComment);
    }

    // 특정 reviewComment 수정하기
    @PutMapping("/{reviewCommentId}")
    public void modifyReviewComment(@RequestBody ReviewComment reviewComment) {
        reviewCommentService.modifyReviewComment(reviewComment);
    }

    // 특정 reviewComment 삭제
    // reviewComment 지워지면 해당 reviewComment 밑에 있는 recomment들도 지워지도록 함.
    @DeleteMapping("/{reviewCommentId}")
    public void removeReviewComment(@PathVariable Integer reviewCommentId) {
        reviewCommentService.removeReviewComment(reviewCommentId);
    }

}
