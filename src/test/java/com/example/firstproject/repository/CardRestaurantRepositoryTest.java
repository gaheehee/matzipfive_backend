package com.example.firstproject.repository;

import com.example.firstproject.model.CardRestaurant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CardRestaurantRepositoryTest {

    @Autowired
    private CardRestaurantRepository cardRestaurantRepository;

    @Test
    public void CaardRestauranatSaveTest(){

        // given
        final CardRestaurant cardRestaurant = CardRestaurant.builder()
                .restaurantId(1)
                .cardId(1)
                .build();

        // when
        final CardRestaurant savedCardRestaurant = cardRestaurantRepository.save(cardRestaurant);

        // then
        assertEquals(1, savedCardRestaurant.getRestaurantId());
        assertEquals(1, savedCardRestaurant.getCardId());
    }
}
