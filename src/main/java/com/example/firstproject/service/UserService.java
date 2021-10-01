package com.example.firstproject.service;

import com.example.firstproject.model.Review;
import com.example.firstproject.model.User;
import com.example.firstproject.model.UserHeartReview;
//import com.example.firstproject.model.UserRegisteredTheme;
import com.example.firstproject.model.UserSavedRestaurants;
import com.example.firstproject.repository.ReviewRepository;
import com.example.firstproject.repository.UserSavedRestaurantsRepository;
import com.example.firstproject.repository.UserHeartReviewRepository;
//import com.example.firstproject.repository.UserRegisteredThemeRepository;
import com.example.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    ReviewRepository reviewRepository;

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

    // user가 하트 누른 리뷰들 리턴
    /*public List<Review> getHeartReviewsByUserId(String userId) {

        List<UserHeartReview> userHeartReviews =  userHeartReviewRepository.findAllByUserId(userId);

        List<Integer> reviewIds = new ArrayList<>();
        for(int i=0; i < userHeartReviews.size(); i++){
            reviewIds.add(userHeartReviews.get(i).getReviewId());
        }

        List<Review> reviews = new ArrayList<>();
        Review review = new Review();
        for(int i=0; i < reviewIds.size(); i++){
            review = reviewRepository.getById(reviewIds.get(i));
            reviews.add(review);
        }
        return reviews;
    }*/
    public List<UserHeartReview> getHeartReviewByUserId(String userId){
        List<UserHeartReview> userHeartReviews = userHeartReviewRepository.findAllByUserId(userId);
        return userHeartReviews;
    }

    // user가 리뷰에 하트 눌렀을때, review 테이블에서 해당 리뷰 heartNum 수 증가
    public UserHeartReview insertHeartReview(UserHeartReview userHeartReview) {
        userHeartReviewRepository.save(userHeartReview);
        Integer reviewId = userHeartReview.getReviewId();
        Review review = reviewRepository.findByReviewId(reviewId);
        review.setHeartNum(review.getHeartNum()+1);
        reviewRepository.save(review);
        return userHeartReview;
    }

    // user가 리뷰 하트 누른거 취소
    public void deleteHeartReviewByUserIdAndReviewId(String userId, Integer reviewId) {
        userHeartReviewRepository.deleteByUserIdAndReviewId(userId, reviewId);
        Review review = reviewRepository.findByReviewId(reviewId);
        review.setHeartNum(review.getHeartNum()-1);
        reviewRepository.save(review);
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