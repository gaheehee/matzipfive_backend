package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Restaurant {

    private Integer restaurantId;
    private String restaurantName;

    @JsonCreator
    @Builder
    public Restaurant( @JsonProperty("restaurantId") Integer restaurantId,
                       @JsonProperty("restaurantName") String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public Integer getRestaurantId() { return restaurantId; }

    public void setRestaurantId(Integer restaurantId) { this.restaurantId = restaurantId; }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
