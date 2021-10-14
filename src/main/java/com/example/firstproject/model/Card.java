package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "card")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer cardId;
    @Column(name = "created_at")
    public String createdAt;
    //@Column(name = "user_id")
    //private String userId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;


    @JsonCreator
    @Builder
    public Card(@JsonProperty("card_id") Integer cardId,
                @JsonProperty("created_at") String createdAt) {

        this.cardId = cardId;
        //this.userId = userId;
        this.createdAt = createdAt;
    }

}
