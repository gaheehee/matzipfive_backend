package com.example.firstproject.dao;

import com.example.firstproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public static List<Integer> amooguna;
    static{
        amooguna = new ArrayList<>();
        amooguna.add(1); amooguna.add(2); amooguna.add(3);
    }

    public static List<User> users;

    //실제 데이터는 DB에서 가져오는게 맞으나 .... 아직 DB가 없으니 임시로 세팅해놓음
    static {
        users = new ArrayList<>();
        users.add(new User("testId1","testName1", "1234",amooguna,amooguna, amooguna));
        users.add(new User("testId2","testName2", "1234",amooguna, amooguna,amooguna));
        users.add(new User("testId3","testName3", "1234",amooguna,amooguna,amooguna));
    }

    // Select all user.
    public List<User> getAllUsers() {
        return users;
    }

    // Select one user by userId
    public User getUserByUserId(String userId) {
        return users
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", "",null, null, null));
    }

    // Insert User
    public User insertUser(User user) {
        users.add(user);

        return user;
    }

    // Modify User
    public void updateUser(String userId,User user) {
        // 유저가 저장한 맛집 수정 업뎃
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", "",null,null,null))
                .setSaved_restaurants(user.getSaved_restaurants());

        // 유저가 생성한 themeId 수정 업뎃
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", "",null,null,null))
                .setUserRegister_themeIds(user.userRegister_themeIds);

        // 유저가 하트누른 리뷰아이디 수정 업뎃
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", "",null,null,null))
                .setUser_heart_reviewIds(user.getUser_heart_reviewIds());
    }

    // Delete User
    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}