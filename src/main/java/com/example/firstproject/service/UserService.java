package com.example.firstproject.service;

import com.example.firstproject.model.Review;
import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReview;
import com.example.firstproject.model.UserSavedRestaurants;
import com.example.firstproject.repository.ReviewRepository;
import com.example.firstproject.repository.UserSavedRestaurantsRepository;
import com.example.firstproject.repository.UserHeartReviewRepository;
import com.example.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserHeartReviewRepository userHeartReviewRepository;
    @Autowired
    UserSavedRestaurantsRepository savedRestaurantsRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserByUserId(String userId) {
        User user = userRepository.getById(userId);
        return user;
    }

    @Transactional
    public User registerUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
        return user;
    }

    public void modifyUser(String userId, User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userRepository.save(user);
    }

    public void removeUser(String userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
    }

    public List<UserHeartReview> getHeartReviewByUserId(String userId){
        List<UserHeartReview> userHeartReviews = userHeartReviewRepository.findAllByUserId(userId);
        return userHeartReviews;
    }

    public UserHeartReview insertHeartReview(UserHeartReview userHeartReview) {
        userHeartReviewRepository.save(userHeartReview);
        Integer reviewId = userHeartReview.getReviewId();
        Review review = reviewRepository.findByReviewId(reviewId);
        review.setHeartNum(review.getHeartNum()+1);
        reviewRepository.save(review);
        return userHeartReview;
    }

    public void deleteHeartReviewByUserIdAndReviewId(String userId, Integer reviewId) {
        userHeartReviewRepository.deleteByUserIdAndReviewId(userId, reviewId);
        Review review = reviewRepository.findByReviewId(reviewId);
        review.setHeartNum(review.getHeartNum()-1);
        reviewRepository.save(review);
    }

    public List<UserSavedRestaurants> getSavedRestaurantsByUserId(String userId) {
        List<UserSavedRestaurants> userSavedRestaurants = savedRestaurantsRepository.findAllByUserId(userId);
        return userSavedRestaurants;
    }

    public UserSavedRestaurants insertSavedRestaurant(UserSavedRestaurants savedRestaurants) {
        return savedRestaurantsRepository.save(savedRestaurants);
    }

    public void deleteSavedRestaurantByUserIdAndRestaurantId(String userId, Integer restaurantId) {
        savedRestaurantsRepository.deleteByUserIdAndRestaurantId(userId, restaurantId);
    }

    public Boolean comparePassword(User user) {
        User realUser = userRepository.getById(user.getUserId());

        if (passwordEncoder.matches(user.getUserPassword(), realUser.getUserPassword())) {
            return true;
        }
        return false;
    }

}