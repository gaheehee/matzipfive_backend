package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity(name = "review_comment")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewComment {

    @Id
    @Column(name = "review_comment_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer reviewCommentId;
    //@Column(name = "review_id")
    //private Integer reviewId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    public String createdAt;


    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @JsonCreator
    @Builder
    public ReviewComment(
                         @JsonProperty("reviewCommentId") Integer reviewCommentId,
                         @JsonProperty("userId") String userId,
                         @JsonProperty("content") String content,
                         @JsonProperty("createAt") String createdAt) {

        //this.reviewId = reviewId;
        this.reviewCommentId = reviewCommentId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

}
