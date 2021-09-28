package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;

@Entity(name = "userheartreviewids")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserHeartReviewIds {

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
    public UserHeartReviewIds(@JsonProperty("id") Integer id,
                              @JsonProperty("user_id") String userId,
                              @JsonProperty("review_id") Integer reviewId) {
        this.id = id;
        this.userId = userId;
        this.reviewId = reviewId;
    }
}
