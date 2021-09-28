package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "review")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Review {

    @Id
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "content")
    private String content;
    @Column(name = "heart_num")
    private Integer heart_num;
    @Column(name = "created_at")
    public String createdAt;

    @JsonCreator
    @Builder
    public Review(@JsonProperty("restaurant_id") Integer restaurantId,
                  @JsonProperty("review_id") Integer reviewId,
                  @JsonProperty("user_id") String userId,
                  @JsonProperty("content") String content,
                  @JsonProperty("heart_num") Integer heart_num,
                  @JsonProperty("created_at") String createdAt) {

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
