package com.example.firstproject.service;

import com.example.firstproject.dao.RecommentDao;
import com.example.firstproject.model.Recomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RecommentService {

    @Autowired
    RecommentDao recommentDao;

    public List<Recomment> getAllRecomments() {
        return recommentDao.getAllRecomments();
    }

    public Recomment getRecommentByReviewCommentId(Integer reviewCommentId) {
        return recommentDao.getRecommentByReviewCommentId(reviewCommentId);
    }

    public Recomment registerRecomment(Recomment recomment) {
        return recommentDao.insertRecomment(recomment);
    }

    public void modifyRecomment(Integer recommentId, Recomment recomment) {
        recommentDao.updateRecomment(recommentId, recomment);
    }

    public void removeRecomment(Integer recommentId) {
        recommentDao.deleteRecomment(recommentId);
    }
}
