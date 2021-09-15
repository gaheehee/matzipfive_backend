package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewComment {

    private Integer reviewId;
    private Integer reviewCommentId;
    private Integer userId;
    private String comment;
    private String createdAt;

    @JsonCreator
    @Builder
    public ReviewComment(@JsonProperty("reviewId") Integer reviewId,
                         @JsonProperty("reviewCommentId") Integer reviewCommentId,
                         @JsonProperty("userId") Integer userId,
                         @JsonProperty("comment") String comment,
                         @JsonProperty("createAt") String createdAt) {

        this.reviewId = reviewId;
        this.reviewCommentId = reviewCommentId;
        this.userId = userId;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Integer getReviewCommentId() {
        return reviewCommentId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getComment() {
        return comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setReviewCommentId(Integer reviewCommentId) {
        this.reviewCommentId = reviewCommentId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
