package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "cardrestaurantids")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CardRestaurantIds {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "card_id")
    private Integer cardId;
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @JsonCreator
    @Builder
    public CardRestaurantIds(@JsonProperty("id") Integer id,
                             @JsonProperty("card_id") Integer cardId,
                             @JsonProperty("restaurant_id") Integer restaurantId) {
        this.id = id;
        this.cardId = cardId;
        this.restaurantId = restaurantId;
    }
}
