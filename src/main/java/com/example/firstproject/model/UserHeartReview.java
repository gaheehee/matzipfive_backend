package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user_heart_review")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserHeartReview {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "review_id")
    private Integer reviewId;

    @JsonCreator
    @Builder
    public UserHeartReview(@JsonProperty("id") Integer id,
                           @JsonProperty("user_id") String userId,
                           @JsonProperty("review_id") Integer reviewId) {
        this.id = id;
        this.userId = userId;
        this.reviewId = reviewId;
    }
}
