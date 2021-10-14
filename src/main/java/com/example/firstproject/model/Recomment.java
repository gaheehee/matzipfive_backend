package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "recomment")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recomment {

    @Id
    @Column(name = "recomment_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer recommentId;
    //@Column(name = "review_comment_id")
    //private Integer reviewCommentId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "content")
    private String content;
    @Column(name = "created_at")
    public String createdAt;


    @OneToOne
    @JoinColumn(name = "reviewComment_id")
    private ReviewComment reviewComment;


    @JsonCreator
    public Recomment(
                     @JsonProperty("recomment_id") Integer recommentId,
                     @JsonProperty("user_id") String userId,
                     @JsonProperty("content") String content,
                     @JsonProperty("created_at") String createdAt) {

        //this.reviewCommentId = reviewCommentId;
        this.recommentId = recommentId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

}
