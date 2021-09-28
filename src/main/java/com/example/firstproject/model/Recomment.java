package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "recomment")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Recomment {

    @Id
    @Column(name = "recomment_id")
    private Integer recommentId;
    @Column(name = "review_comment_id")
    private Integer reviewCommentId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    public String createdAt;

    @JsonCreator
    @Builder
    public Recomment(@JsonProperty("review_comment_id") Integer reviewCommentId,
                     @JsonProperty("recomment_id") Integer recommentId,
                     @JsonProperty("user_id") String userId,
                     @JsonProperty("comment") String comment,
                     @JsonProperty("created_at") String createdAt) {

        this.reviewCommentId = reviewCommentId;
        this.recommentId = recommentId;
        this.userId = userId;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Integer getRecommentId() {
        return recommentId;
    }

    public Integer getReviewCommentId() {
        return reviewCommentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setRecommentId(Integer recommentId) {
        this.recommentId = recommentId;
    }

    public void setReviewCommentId(Integer reviewCommentId) {
        this.reviewCommentId = reviewCommentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(String createAt) {
        this.createdAt = createAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
