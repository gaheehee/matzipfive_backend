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

    @GetMapping("") //얘 필요없음
    public List<Recomment> getAllRecomments() {
        return recommentService.getAllRecomments();
    }

    @GetMapping("/{reviewCommentId}")
    public Recomment getRecommentByReviewCommentId(@PathVariable Integer reviewCommentId) {
        return recommentService.getRecommentByReviewCommentId(reviewCommentId);
    }

    @PostMapping("")
    public Recomment registerRecomment(@RequestBody Recomment recomment) {
        return recommentService.registerRecomment(recomment);
    }

    @PutMapping("/{reviewCommentId}/{recommentId}")
    public void modifyRecomment(@PathVariable Integer recommentId, @RequestBody Recomment recomment) {
        recommentService.modifyRecomment(recommentId, recomment);
    }

    @DeleteMapping("/{reviewCommentId}/{recommentId}")
    public void removeRecomment(@PathVariable Integer recommentId) {
        recommentService.removeRecomment(recommentId);
    }
}
