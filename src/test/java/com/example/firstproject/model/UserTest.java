package com.example.firstproject.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void lombokTest() {
        // given
        String userId = "jghgahee";
        String userName = "gahee";
        String userPassword = "password123";

        //  when
        User user = new User(userId, userName, userPassword);

        // then
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getUserPassword()).isEqualTo(userPassword);
    }
}
