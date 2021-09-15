package com.example.firstproject.dao;

import com.example.firstproject.model.Review;
import com.example.firstproject.model.ReviewComment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewCommentDao {

    public static List<ReviewComment> reviewComments;

    static{
        reviewComments = new ArrayList<>();
        reviewComments.add(new ReviewComment(1,1,32,"맞아","2021년 8월 17일 1:56 PM"));
        reviewComments.add(new ReviewComment(1,2,5,"나도 맛있더라","2016년 5월 10일 1:56 PM"));
        reviewComments.add(new ReviewComment(2,3,32,"ㅋㅋㅋ","2021년 8월 1일 1:56 PM"));
        reviewComments.add(new ReviewComment(4,4,2,"맛있겠다~","2011년 4월 7일 1:56 PM"));
    }

    public List<ReviewComment> getAllReviewComments() {
        return reviewComments;
    }

    public List<ReviewComment> getReviewCommentsByReviewId(Integer reviewId) {
        List<ReviewComment> reviewCommentList = reviewComments.stream() .filter(review -> review.getReviewId().equals(reviewId)) .collect(Collectors.toList());
        return reviewCommentList;
    }

    public ReviewComment insertReviewComment(ReviewComment reviewComment) {
        reviewComments.add(reviewComment);
        return reviewComment;
    }

    public void updateReviewComment(Integer reviewCommentId, ReviewComment reviewComment) {
        reviewComments.stream()
                .filter(curReviewComment -> curReviewComment.getReviewCommentId().equals(reviewCommentId))
                .findAny()
                .orElse(new ReviewComment(-1,-1,-1,"",""))
                .setComment(reviewComment.getComment());
    }

    public void deleteReviewComment(Integer reviewCommentId) {
        reviewComments.removeIf(reviewComment -> reviewComment.getReviewCommentId().equals(reviewCommentId));
    }
}
