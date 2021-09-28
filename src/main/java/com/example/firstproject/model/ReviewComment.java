package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "review_comment")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewComment {

    @Id
    @Column(name = "review_comment_id")
    private Integer reviewCommentId;
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    public String createdAt;

    @JsonCreator
    @Builder
    public ReviewComment(@JsonProperty("reviewId") Integer reviewId,
                         @JsonProperty("reviewCommentId") Integer reviewCommentId,
                         @JsonProperty("userId") String userId,
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

    public String getUserId() {
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
