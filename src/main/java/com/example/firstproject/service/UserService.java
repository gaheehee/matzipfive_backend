package com.example.firstproject.service;

import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReview;
//import com.example.firstproject.model.UserRegisteredTheme;
import com.example.firstproject.model.UserSavedRestaurants;
import com.example.firstproject.repository.UserSavedRestaurantsRepository;
import com.example.firstproject.repository.UserHeartReviewRepository;
//import com.example.firstproject.repository.UserRegisteredThemeRepository;
import com.example.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    /*@Autowired
    UserRegisteredThemeRepository userRegisteredThemeRepository;*/
    @Autowired
    UserHeartReviewRepository userHeartReviewRepository;
    @Autowired
    UserSavedRestaurantsRepository savedRestaurantsRepository;

    // Select all user.
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    // Select one user by userId
    public User getUserByUserId(String userId) {
        //System.out.println(userId);
        User user = userRepository.getById(userId);
        //System.out.println(user);
        return user;
    }

    // Insert User
    public User registerUser(User user) {
        userRepository.save(user);
        return user;
    }

    // Modify User
    public void modifyUser(String userId, User user) {
        userRepository.save(user);
    }

    // Delete User
    // user가 지워지면 테마도 지워지나..?
    public void removeUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
    }

    // ---------------------------------------------------------------------

    // user가 하트 누른 리뷰id 정보 리턴
    public List<UserHeartReview> getHeartReviewsByUserId(String userId) {
        List<UserHeartReview> userHeartReviewIds =  userHeartReviewRepository.findAllByUserId(userId);
        return userHeartReviewIds;
    }

    // user가 리뷰에 하트 눌렀을때
    public UserHeartReview insertHeartReview(UserHeartReview userHeartReviewIds) {
        userHeartReviewRepository.save(userHeartReviewIds);
        return userHeartReviewIds;
    }

    // user가 리뷰 하트 누른거 취소
    public void deleteHeartReviewByUserIdAndReviewId(String userId, Integer reviewId) {
        userHeartReviewRepository.deleteByUserIdAndReviewId(userId, reviewId);
    }

    // user가 저장한 맛집 id 정보 리턴
    public List<UserSavedRestaurants> getSavedRestaurantsByUserId(String userId) {
        List<UserSavedRestaurants> userSavedRestaurants = savedRestaurantsRepository.findAllByUserId(userId);
        return userSavedRestaurants;
    }

    // user가 저장한 맛집 추가
    public UserSavedRestaurants insertSavedRestaurant(UserSavedRestaurants savedRestaurants) {
        return savedRestaurantsRepository.save(savedRestaurants);
    }

    // user가 저장한 맛집 삭제
    public void deleteSavedRestaurantByUserIdAndRestaurantId(String userId, Integer restaurantId) {
        savedRestaurantsRepository.deleteByUserIdAndRestaurantId(userId, restaurantId);
    }

    // user가 등록한 테마id 정보 리턴
    /*public List<UserRegisteredTheme> getRegisterThemeIdsByUserId(String userId) {
        List<UserRegisteredTheme> userRegisterTheme = userRegisteredThemeRepository.findAllByUserId(userId);
        return userRegisterTheme;
    }

    // user가 테마 등록
    public UserRegisteredTheme insertRegisterTheme(UserRegisteredTheme userRegisteredTheme) {
        return userRegisteredThemeRepository.save(userRegisteredTheme);
    }*/

    // user가 등록한 특정 테마 삭제
    /*public void removeRegisterThemeByThemeId(Integer themeId) {
        userRegisteredThemeRepository.deleteByThemeId(themeId);
    }*/
}