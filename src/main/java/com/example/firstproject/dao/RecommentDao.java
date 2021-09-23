package com.example.firstproject.dao;

import com.example.firstproject.model.Recomment;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RecommentDao {

    public List<Recomment> mock_recomments = new ArrayList<>();
    {
        mock_recomments.add(new Recomment(2,1,"ㅇㅈ","2021년 09월 16일, 오후 02:17"));
        mock_recomments.add(new Recomment(4,2,"맞아","2021년 09월 16일, 오후 02:17"));
        mock_recomments.add(new Recomment(1,3,"ㅇㅇㅇㅇ","2021년 09월 16일, 오후 02:17"));
    }
    /*public static List<Recomment> recomments;
    static{
        recomments = new ArrayList<>();
        recomments.add(new Recomment(2,1,"ㅇㅈ","2021년 09월 16일, 오후 02:17"));
        recomments.add(new Recomment(4,2,"맞아","2021년 09월 16일, 오후 02:17"));
        recomments.add(new Recomment(1,3,"ㅇㅇㅇㅇ","2021년 09월 16일, 오후 02:17"));
    }*/

    public List<Recomment> getAllRecomments() {
        return mock_recomments;
    }

    public Recomment getRecommentByReviewCommentId(Integer reviewCommentId) {
        return mock_recomments
                .stream()
                .filter(recomment -> recomment.getReviewCommentId().equals(reviewCommentId))
                .findAny()
                .orElse(new Recomment(-1,-1,"",null));
    }

    public Recomment insertRecomment(Recomment recomment) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        recomment.createdAt = timeStamp;

        mock_recomments.add(recomment);
        return recomment;
    }

    public void updateRecomment(Integer recommentId, Recomment recomment) {
        mock_recomments.stream()
                .filter(curRecomment -> curRecomment.getRecommentId().equals(recommentId))
                .findAny()
                .orElse(new Recomment(-1,-1,"",""))
                .setComment(recomment.getComment());

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);
        recomment.createdAt = timeStamp;

        mock_recomments.stream()
                .filter(curRecomment -> curRecomment.getRecommentId().equals(recommentId))
                .findAny()
                .orElse(new Recomment(-1,-1,"",null))
                .setCreatedAt(recomment.getCreatedAt());
    }

    public void deleteRecomment(Integer recommentId) {
        mock_recomments.removeIf(recomment -> recomment.getRecommentId().equals(recommentId));
    }

}
