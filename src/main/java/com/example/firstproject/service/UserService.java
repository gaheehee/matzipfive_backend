package com.example.firstproject.service;

import com.example.firstproject.dao.UserDao;
import com.example.firstproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    public User registerUser(User user) {
        return userDao.insertUser(user);
    }

    public void modifyUser(String userId, User user) {
        userDao.updateUser(userId, user);
    }

    public void removeUser(String userId) {
        userDao.deleteUser(userId);
    }

}