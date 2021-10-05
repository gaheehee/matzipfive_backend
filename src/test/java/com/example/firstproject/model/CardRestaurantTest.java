package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardRestaurantTest {

    @Test
    public void lombokTest(){
        // given
        Integer id = 5;
        Integer restaurantId = 30;
        Integer cardId = 13;

        // when
        CardRestaurant cardRestaurant = new CardRestaurant(id, restaurantId, cardId);

        // then
        assertThat(cardRestaurant.getId()).isEqualTo(id);
        assertThat(cardRestaurant.getRestaurantId()).isEqualTo(restaurantId);
        assertThat(cardRestaurant.getCardId()).isEqualTo(cardId);
    }
}
