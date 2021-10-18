package com.example.firstproject.repository;

import com.example.firstproject.model.UserSavedRestaurants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserSavedRestaurantRepositoryTest {

    @Autowired
    private UserSavedRestaurantsRepository userSavedRestaurantsRepository;

    @Test
    public void saveUserSavedRestaurantsTest() {
        // given
        final UserSavedRestaurants userSavedRestaurants = UserSavedRestaurants.builder()
                .userId("jghgahee1")
                .restaurantId(1)
                .build();

        // when
        final UserSavedRestaurants savedUserSavedRestaurants = userSavedRestaurantsRepository.save(userSavedRestaurants);

        // then
        assertEquals(userSavedRestaurants.getUserId(),savedUserSavedRestaurants.getUserId());
        assertEquals(1,savedUserSavedRestaurants.getRestaurantId());

    }

    /*@Test
    public void findAllByUserIdSuccessTest(){
        // given
        UserSavedRestaurants userSavedRestaurants = UserSavedRestaurants.builder()
                .userId("jghgahee2")
                .restaurantId(1)
                .build();

        // when
        UserSavedRestaurants savedUserSavedRestaurants = userSavedRestaurantsRepository.save(userSavedRestaurants);
        Optional<List<UserSavedRestaurants>> restaurantsFindByUserId = Optional
                .ofNullable(userSavedRestaurantsRepository
                        .findAllByUserId(savedUserSavedRestaurants.getUserId()));

        // then
        restaurantsFindByUserId.ifPresent(assertEquals(savedUserSavedRestaurants, restaurantsFindByUserId.filter(t->t)));



    }

    @Test
    public void findAllByUserIdFailTest(){
        // given

        // when
        Optional<List<UserSavedRestaurants>> restauranrsFindByserId = Optional
                .ofNullable(userSavedRestaurantsRepository.findAllByUserId("nothing"));

        // then
        assertEquals(Optional.empty(), restauranrsFindByserId);

    }*/

}
