package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "card_restaurant")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CardRestaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Column(name = "card_id")
    private Integer cardId;


    @JsonCreator
    @Builder
    public CardRestaurant(@JsonProperty("id") Integer id,
                          @JsonProperty("restaurant_id") Integer restaurantId,
                          @JsonProperty("card_id") Integer cardId) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.cardId = cardId;
    }
}
