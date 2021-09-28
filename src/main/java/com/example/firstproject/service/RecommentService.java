package com.example.firstproject.service;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.repository.RecommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RecommentService {

    @Autowired
    RecommentRepository recommentRepository;

    public List<Recomment> getAllRecomments() {
        List<Recomment> recomments = recommentRepository.findAll();
        return recomments;
    }

    public Recomment getRecommentByReviewCommentId(Integer reviewCommentId) {
        return recommentRepository.getById(reviewCommentId);
    }

    public Recomment registerRecomment(Recomment recomment) {
        recommentRepository.save(recomment);
        return recomment;
    }

    public void modifyRecomment(Integer recommentId, Recomment recomment) {
        recommentRepository.save(recomment);
    }

    public void removeRecomment(Integer recommentId) {
        recommentRepository.deleteById(recommentId);
    }
}
