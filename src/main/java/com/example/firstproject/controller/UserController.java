package com.example.firstproject.controller;

import com.example.firstproject.model.UserSavedRestaurants;
import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReview;
//import com.example.firstproject.model.UserRegisteredTheme;
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

    //--------------------------------------------------------------------------------

    // user가 하트누른 리뷰 id 정보
    @GetMapping("/heartReviews/{userId}")
    public List<UserHeartReview> getHeartReviewsByUserId(@PathVariable String userId){
        return userService.getHeartReviewsByUserId(userId);
    }

    // user가 리뷰에 하트 눌렀을때
    @PostMapping("/heartReviews")
    public UserHeartReview insertHeartReview(@RequestBody UserHeartReview userHeartReviewIds){
        return userService.insertHeartReview(userHeartReviewIds);
    }

    // user가 리뷰 하트 누른거 취소
    @DeleteMapping("/heartReviews/{userId}/{reviewId}")
    public void deleteHeartReviewByUserIdAndReviewId(@PathVariable String userId, @PathVariable Integer reviewId){
        userService.deleteHeartReviewByUserIdAndReviewId(userId, reviewId);
    }


    // user가 저장한 맛집 id 정보
    @GetMapping("/savedRestaurants/{userId}")
    public List<UserSavedRestaurants> getSavedRestaurantsByUserId(@PathVariable String userId){
        return userService.getSavedRestaurantsByUserId(userId);
    }

    // user가 저장한 맛집 추가
    @PostMapping("savedRestaurants")
    public UserSavedRestaurants insertSavedRestaurant(@RequestBody UserSavedRestaurants savedRestaurants){
        return userService.insertSavedRestaurant(savedRestaurants);
    }

    // user가 저장한 맛집 삭제
    @DeleteMapping("/savedRestaurants/{userId}/{restaurantId}")
    public void deleteSaveRestaurantByUserIdAndRestaurantId(@PathVariable String userId, @PathVariable Integer restaurantId){
        userService.deleteSavedRestaurantByUserIdAndRestaurantId(userId, restaurantId);
    }

    // user가 등록한 테마 id 정보
    /*@GetMapping("/registerThemes/{userId}")
    public List<UserRegisteredTheme> getRegisterThemeIdsByUserId(@PathVariable String userId){
        return userService.getRegisterThemeIdsByUserId(userId);
    }

    @PostMapping("/registerThemes")
    public UserRegisteredTheme insertRegisterTheme(@RequestBody UserRegisteredTheme userRegisterThemeIds){
        return userService.insertRegisterTheme(userRegisterThemeIds);
    }

    @DeleteMapping("/registerThemes/{userId}/{themeId}")
    public void removeRegisterThemeByThemeId(@PathVariable String userId, @PathVariable Integer themeId){
        userService.removeRegisterThemeByThemeId(themeId);
    }*/
}
