package com.example.firstproject.repository;

import com.example.firstproject.model.User;
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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserTest() {

        // given

        User user = new User("jghgahee","gahee", "password123");

        // when
        final User savedUser = userRepository.save(user);

        // then
        assertEquals("jghgahee",savedUser.getUserId());
        assertEquals("gahee", savedUser.getUserName());
        assertEquals("password123", savedUser.getUserPassword());
    }
}

