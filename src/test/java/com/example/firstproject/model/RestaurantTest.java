package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTest {

    @Test
    public void lombokTest() {
        // given
        Integer restaurantId = 30;
        String restaurantName = "ice cream";

        // when
        Restaurant restaurant = new Restaurant(restaurantId, restaurantName);

        // then
        assertThat(restaurant.getRestaurantId()).isEqualTo(restaurantId);
        assertThat(restaurant.getRestaurantName()).isEqualTo(restaurantName);
    }
}
