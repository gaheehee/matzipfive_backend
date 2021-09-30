package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "card")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cardId;
    @Column(name = "created_at")
    public String createdAt;

    //얘도 객체 참조할까?
    //@Column(name = "user_id")
    //private String userId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    /*@ManyToMany(mappedBy = "card")    // 외래키 여기에 안 가지고 있음을 뜻함.
    private List<Restaurant> restaurant = new ArrayList<>();*/


    @JsonCreator
    @Builder
    public Card(@JsonProperty("card_id") Integer cardId,
                @JsonProperty("created_at") String createdAt) {

        this.cardId = cardId;
        //this.userId = userId;
        this.createdAt = createdAt;
    }

}
