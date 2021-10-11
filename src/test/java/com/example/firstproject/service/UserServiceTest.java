package com.example.firstproject.service;

import com.example.firstproject.model.User;
import com.example.firstproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void registerUserSuccessTest(){
        final User user = new User("jghgahee", "gahee", "password");
        userService.registerUser(user);

    }

}
