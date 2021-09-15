package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Card {

    private Integer cardId;
    private String userId;
    private String createdAt;

    @JsonCreator
    @Builder
    public Card(@JsonProperty("cardId") Integer cardId,
                @JsonProperty("userId") String userId,
                @JsonProperty("createdAt") String createdAt) {

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
