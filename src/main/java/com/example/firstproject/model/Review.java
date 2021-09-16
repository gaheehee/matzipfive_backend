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
    private String userId;
    private String content;
    private Integer heart_num;
    public String createdAt;

    @JsonCreator
    @Builder
    public Review(@JsonProperty("restaurantId") Integer restaurantId,
                  @JsonProperty("reviewId") Integer reviewId,
                  @JsonProperty("userId") String userId,
                  @JsonProperty("content") String content,
                  @JsonProperty("heart_num") Integer heart_num,
                  @JsonProperty("createAt") String createdAt) {

        this.restaurantId = restaurantId;
        this.reviewId = reviewId;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
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

    public void setUserId(String userId) {
        this.userId = userId;
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
