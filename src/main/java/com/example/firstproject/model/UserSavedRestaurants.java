package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity(name = "user_saved_restaurants")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserSavedRestaurants {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @JsonCreator
    @Builder
    public UserSavedRestaurants(@JsonProperty("id") Integer id,
                                @JsonProperty("user_id") String userId,
                                @JsonProperty("restaurant_id") Integer restaurantId) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }
}
