package com.example.firstproject.dao;

import com.example.firstproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    public static List<User> users;

    //실제 데이터는 DB에서 가져오는게 맞으나 .... 아직 DB가 없으니 임시로 세팅해놓음
    static {
        users = new ArrayList<>();
        users.add(new User("testId1","testName1", "1234"));
        users.add(new User("testId2","testName2", "1234"));
        users.add(new User("testId3","testName3", "1234"));
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
                .orElse(new User("", "", ""));
    }

    // Insert User
    public User insertUser(User user) {
        users.add(user);

        return user;
    }

    // Modify User
    public void updateUser(String userId,User user) {
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", ""))
                .setUserName(user.getUserName());
    }

    // Delete User
    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}