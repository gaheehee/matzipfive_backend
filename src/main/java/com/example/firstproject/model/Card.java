package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
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
    @Column(name = "user_id")
    private String userId;
    @Column(name = "created_at")
    public String createdAt;

    @JsonCreator
    @Builder
    public Card(@JsonProperty("card_id") Integer cardId,
                @JsonProperty("user_id") String userId,
                @JsonProperty("created_at") String createdAt) {

        this.cardId = cardId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public Integer getCardId() { return cardId; }

    public void setCardId(Integer cardId) { this.cardId = cardId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

}
