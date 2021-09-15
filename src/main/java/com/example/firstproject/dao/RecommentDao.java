package com.example.firstproject.dao;

import com.example.firstproject.model.Recomment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecommentDao {

    public static List<Recomment> recomments;

    static{
        recomments = new ArrayList<>();
        recomments.add(new Recomment(2,1,"ㅇㅈ","2016년 8월 10일 1:56 PM"));
        recomments.add(new Recomment(4,2,"맞아","2021년 4월 10일 1:56 PM"));
        recomments.add(new Recomment(1,3,"ㅇㅇㅇㅇ","2020년 5월 10일 1:56 PM"));
    }

    public List<Recomment> getAllRecomments() {
        return recomments;
    }

    public Recomment getRecommentByReviewCommentId(Integer reviewCommentId) {
        return recomments
                .stream()
                .filter(recomment -> recomment.getReviewCommentId().equals(reviewCommentId))
                .findAny()
                .orElse(new Recomment(-1,-1,"",""));
    }

    public Recomment insertRecomment(Recomment recomment) {
        recomments.add(recomment);
        return recomment;
    }

    public void updateRecomment(Integer recommentId, Recomment recomment) {
        recomments.stream()
                .filter(curRecomment -> curRecomment.getRecommentId().equals(recommentId))
                .findAny()
                .orElse(new Recomment(-1,-1,"",""))
                .setComment(recomment.getComment());
    }

    public void deleteRecomment(Integer recommentId) {
        recomments.removeIf(recomment -> recomment.getRecommentId().equals(recommentId));
    }

}
