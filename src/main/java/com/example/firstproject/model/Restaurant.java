package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;


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


    @JsonCreator
    @Builder
    public Restaurant( @JsonProperty("restaurant_id") Integer restaurantId,
                       @JsonProperty("restaurant_name") String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

}
