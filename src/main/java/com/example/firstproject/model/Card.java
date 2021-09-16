package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
public class Card {

    private Integer cardId;
    private String userId;
    public String createdAt;
    public List<Integer> card_restaurantIds;

    @JsonCreator
    @Builder
    public Card(@JsonProperty("cardId") Integer cardId,
                @JsonProperty("userId") String userId,
                @JsonProperty("createdAt") String createdAt,
                @JsonProperty("card_restaurantIds") List<Integer> card_restaurantIds) {

        this.cardId = cardId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.card_restaurantIds = card_restaurantIds;
    }

    public Integer getCardId() { return cardId; }

    public void setCardId(Integer cardId) { this.cardId = cardId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getCreatedAt() { return createdAt; }

    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public List<Integer> getCard_restaurantIds() {
        return card_restaurantIds;
    }

    public void setCard_restaurantIds(List<Integer> card_restaurantIds) {
        this.card_restaurantIds = card_restaurantIds;
    }
}
