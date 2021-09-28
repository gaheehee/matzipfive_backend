package com.example.firstproject.service;

import com.example.firstproject.model.SavedRestaurants;
import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReviewIds;
import com.example.firstproject.model.UserRegisterThemeIds;
import com.example.firstproject.repository.SavedRestaurantsRepository;
import com.example.firstproject.repository.UserHeartReviewIdsRepository;
import com.example.firstproject.repository.UserRegisterThemeIdsRepository;
import com.example.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRegisterThemeIdsRepository userRegisterThemeIdsRepository;
    @Autowired
    UserHeartReviewIdsRepository userHeartReviewIdsRepository;
    @Autowired
    SavedRestaurantsRepository savedRestaurantsRepository;

    // Select all user.
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    // Select one user by userId
    public User getUserByUserId(String userId) {
        System.out.println(userId);
        User user = userRepository.getById(userId);
        System.out.println(user);
        return user;
    }

    // Insert User
    public User registerUser(User user) {
        userRepository.save(user);
        return user;    // 리턴 굳이 안해도 됌.
    }

    // Modify User
    public void modifyUser(String userId,User user) {
        userRepository.save(user);  // db에 동일한 userId가 있으면 알아서 업뎃해줌?
    }

    // Delete User
    public void removeUser(String userId) {
        Optional<User> user = userRepository.findById(userId);

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
    }

    // user가 등록한 테마id 정보 리턴
    public List<UserRegisterThemeIds> getRegisterThemeIdsByUserId(String userId) {
        List<UserRegisterThemeIds> userRegisterThemeIds = userRegisterThemeIdsRepository.findAllByUserId(userId);
        return userRegisterThemeIds;
    }

    // user가 누른 리뷰id 정보 리턴
    public List<UserHeartReviewIds> getHeartReviewsByUserId(String userId) {
        List<UserHeartReviewIds> userHeartReviewIds =  userHeartReviewIdsRepository.findAllByUserId(userId);
        return userHeartReviewIds;
    }

    // user가 저장한 맛집 id 정보 리턴
    public List<SavedRestaurants> getSavedRestaurantsByUserId(String userId) {
        List<SavedRestaurants> savedRestaurants = savedRestaurantsRepository.findAllByUserId(userId);
        return savedRestaurants;
    }
}