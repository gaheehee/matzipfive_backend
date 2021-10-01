package com.example.firstproject.controller;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.service.RecommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomments")
public class RecommentController {

    @Autowired
    RecommentService recommentService;

    // 모든 recomment 가져오기
    @GetMapping("")
    public List<Recomment> getAllRecomments() {
        return recommentService.getAllRecomments();
    }

    // 특정 reviewComment에 달린 recomment들 가져오기
    @GetMapping("/{reviewCommentId}")
    public Recomment getRecommentByReviewCommentId(@PathVariable Integer reviewCommentId) {
        return recommentService.getRecommentByReviewCommentId(reviewCommentId);
    }

    // 특정 reviewComment에 recomment(대댓글) 달기
    @PostMapping("/registration/{reviewCommentId}")
    public Recomment registerRecomment(@PathVariable Integer reviewCommentId ,@RequestBody Recomment recomment) {
        return recommentService.registerRecomment(reviewCommentId, recomment);
    }

    // 특정 recomment 수정
    @PutMapping("/{recommentId}")
    public void modifyRecomment(@RequestBody Recomment recomment) {
        recommentService.modifyRecomment(recomment);
    }

    // 특정 recomment 삭제
    @DeleteMapping("/{recommentId}")
    public void removeRecomment(@PathVariable Integer recommentId) {
        recommentService.removeRecomment(recommentId);
    }
}
