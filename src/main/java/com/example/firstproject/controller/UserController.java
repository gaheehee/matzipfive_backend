package com.example.firstproject.controller;

import com.example.firstproject.model.SavedRestaurants;
import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReviewIds;
import com.example.firstproject.model.UserRegisterThemeIds;
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

    // user가 등록한 테마 id 정보
    @GetMapping("/registerThemes/{userId}")
    public List<UserRegisterThemeIds> getRegisterThemeIdsByUserId(@PathVariable String userId){
        return userService.getRegisterThemeIdsByUserId(userId);
    }

    // user가 누른 리뷰 id 정보
    @GetMapping("/heartReviews/{userId}")
    public List<UserHeartReviewIds> getHeartReviewsByUserId(@PathVariable String userId){
        return userService.getHeartReviewsByUserId(userId);
    }

    // user가 저장한 맛집 id 정보
    @GetMapping("/savedRestaurants/{userId}")
    public List<SavedRestaurants> getSavedRestaurantsByUserId(@PathVariable String userId){
        return userService.getSavedRestaurantsByUserId(userId);
    }

    // 확인
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
