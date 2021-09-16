package com.example.firstproject.dao;

import com.example.firstproject.model.Recomment;
import com.example.firstproject.model.ReviewComment;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewCommentDao {

    public static List<ReviewComment> reviewComments;

    static{
        reviewComments = new ArrayList<>();
        reviewComments.add(new ReviewComment(1,1,"userId1","맞아","2021년 09월 16일, 오후 02:17"));
        reviewComments.add(new ReviewComment(1,2,"userId2","나도 맛있더라","2021년 09월 16일, 오후 02:17"));
        reviewComments.add(new ReviewComment(2,3,"userId3","ㅋㅋㅋ","2021년 09월 16일, 오후 02:17"));
        reviewComments.add(new ReviewComment(4,4,"userId4","맛있겠다~","2021년 09월 16일, 오후 02:17"));
    }

    public List<ReviewComment> getAllReviewComments() {
        return reviewComments;
    }

    public List<ReviewComment> getReviewCommentsByReviewId(Integer reviewId) {
        List<ReviewComment> reviewCommentList = reviewComments.stream() .filter(review -> review.getReviewId().equals(reviewId)) .collect(Collectors.toList());
        return reviewCommentList;
    }

    public ReviewComment insertReviewComment(ReviewComment reviewComment) {
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);

        reviewComment.createdAt = timeStamp;
        reviewComments.add(reviewComment);
        return reviewComment;
    }

    public void updateReviewComment(Integer reviewCommentId, ReviewComment reviewComment) {
        reviewComments.stream()
                .filter(curReviewComment -> curReviewComment.getReviewCommentId().equals(reviewCommentId))
                .findAny()
                .orElse(new ReviewComment(-1,-1,"","",""))
                .setComment(reviewComment.getComment());

        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy'년' MM'월' dd'일', a hh:mm");
        String timeStamp = formatter.format(today);
        reviewComment.createdAt = timeStamp;

        reviewComments.stream()
                .filter(curRecomment -> curRecomment.getReviewCommentId().equals(reviewCommentId))
                .findAny()
                .orElse(new ReviewComment(-1,-1,"","",null))
                .setCreatedAt(reviewComment.getCreatedAt());
    }

    public void deleteReviewComment(Integer reviewCommentId) {
        reviewComments.removeIf(reviewComment -> reviewComment.getReviewCommentId().equals(reviewCommentId));
    }
}
