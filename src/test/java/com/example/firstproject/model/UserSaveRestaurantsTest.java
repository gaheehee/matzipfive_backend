package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSaveRestaurantsTest {

    @Test
    public void lombokTest() {
        // given
        Integer id = 10;
        String userId = "gahee";
        Integer restaurantId = 15;

        // when
        UserSavedRestaurants userSavedRestaurants = new UserSavedRestaurants(id, userId, restaurantId);

        // then
        assertThat(userSavedRestaurants.getId()).isEqualTo(id);
        assertThat(userSavedRestaurants.getUserId()).isEqualTo(userId);
        assertThat(userSavedRestaurants.getRestaurantId()).isEqualTo(restaurantId);
    }
}
