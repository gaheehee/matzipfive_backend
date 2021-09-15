package com.example.firstproject.controller;

import com.example.firstproject.model.User;
import com.example.firstproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable  String userId) {
        return userService.getUserByUserId(userId);
    }

    @PostMapping("")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    @PutMapping("/{userId}")
    public void modifyUser(@PathVariable String userId, @RequestBody User user) {

        userService.modifyUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable String userId) {
        userService.removeUser(userId);
    }
}
