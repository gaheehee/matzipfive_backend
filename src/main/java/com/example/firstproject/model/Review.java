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
public class Review {

    private Integer restaurantId;
    private Integer reviewId;
    private Integer userNo;
    private String content;
    private Integer heart_num;
    private String createdAt;

    @JsonCreator
    @Builder
    public Review(@JsonProperty("restaurantId") Integer restaurantId,
                  @JsonProperty("reviewId") Integer reviewId,
                  @JsonProperty("userNo") Integer userNo,
                  @JsonProperty("content") String content,
                  @JsonProperty("heart_num") Integer heart_num,
                  @JsonProperty("createAt") String createdAt) {

        this.restaurantId = restaurantId;
        this.reviewId = reviewId;
        this.userNo = userNo;
        this.content = content;
        this.heart_num = heart_num;
        this.createdAt = createdAt;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public String getContent() {
        return content;
    }

    public Integer getHeart_num() {
        return heart_num;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHeart_num(Integer heart_num) {
        this.heart_num = heart_num;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
