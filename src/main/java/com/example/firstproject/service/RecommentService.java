package com.example.firstproject.service;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.repository.RecommentRepository;
import com.example.firstproject.repository.ReviewCommentRepository;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RecommentService {

    @Autowired
    RecommentRepository recommentRepository;
    @Autowired
    ReviewCommentRepository reviewCommentRepository;

    public List<Recomment> getAllRecomments() {
        List<Recomment> recomments = recommentRepository.findAll();
        return recomments;
    }

    public Recomment getRecommentByReviewCommentId(Integer reviewCommentId) {
        return recommentRepository.getById(reviewCommentId);
    }

    public Recomment registerRecomment(Integer reviewCommentId, Recomment recomment) {
        recomment.setReviewComment(reviewCommentRepository.getById(reviewCommentId));

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        recomment.createdAt = timeStamp;
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
