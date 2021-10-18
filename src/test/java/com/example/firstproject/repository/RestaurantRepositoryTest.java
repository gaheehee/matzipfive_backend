package com.example.firstproject.repository;

import com.example.firstproject.model.Restaurant;
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
public class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void saveRestaurantTest () {

        // given
        final Restaurant restaurant = Restaurant.builder()
                .restaurantId(6)
                .restaurantName("yamyam")
                .build();

        // when
        final Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // then
        assertEquals("yamyam", savedRestaurant.getRestaurantName());
    }
}
