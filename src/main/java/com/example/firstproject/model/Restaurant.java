package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "restaurant")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Column(name = "restaurant_name")
    private String restaurantName;

    /*@ManyToMany
    @JoinTable(name = "card_restaurant",
    joinColumns = @JoinColumn(name = "restaurant_id"),
    inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> card = new ArrayList<>();*/


    @JsonCreator
    @Builder
    public Restaurant( @JsonProperty("restaurant_id") Integer restaurantId,
                       @JsonProperty("restaurant_name") String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

}
