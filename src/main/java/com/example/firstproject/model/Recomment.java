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
public class Recomment {

    private Integer reviewCommentId;
    private Integer recommentId;
    private String comment;
    public String createdAt;

    @JsonCreator
    @Builder
    public Recomment(@JsonProperty("reviewCommentId") Integer reviewCommentId,
                     @JsonProperty("recommentId") Integer recommentId,
                     @JsonProperty("comment") String comment,
                     @JsonProperty("createdAt") String createdAt) {

        this.reviewCommentId = reviewCommentId;
        this.recommentId = recommentId;
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
}
