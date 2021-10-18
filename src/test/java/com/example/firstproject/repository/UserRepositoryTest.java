package com.example.firstproject.repository;

import com.example.firstproject.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(value = "dev")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserTest() {

        // given
        String userId = "jghgahee";
        String userName = "gahee";
        String userPassword = "password123";

        final User user = User.builder()
                .userId(userId)
                .userName(userName)
                .userPassword(userPassword)
                .build();

        // when
        final User savedUser = userRepository.save(user);

        // then
        assertEquals(userId,savedUser.getUserId());
        assertEquals(userName, savedUser.getUserName());
        assertEquals(userPassword, savedUser.getUserPassword());
    }
}

