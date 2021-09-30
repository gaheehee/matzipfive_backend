package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "review")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer reviewId;
    //@Column(name = "restaurant_id")
    //private Integer restaurantId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "content")
    private String content;
    @Column(name = "heart_num")
    private Integer heartNum;
    @Column(name = "created_at")
    public String createdAt;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonCreator
    @Builder
    public Review(
                  @JsonProperty("review_id") Integer reviewId,
                  @JsonProperty("user_id") String userId,
                  @JsonProperty("content") String content,
                  @JsonProperty("heart_num") Integer heartNum,
                  @JsonProperty("created_at") String createdAt) {

        //this.restaurantId = restaurantId;
        this.reviewId = reviewId;
        this.userId = userId;
        this.content = content;
        this.heartNum = heartNum;
        this.createdAt = createdAt;
    }

}
