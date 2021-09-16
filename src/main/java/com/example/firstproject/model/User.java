package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@ToString
public class User {

    private String userId;
    private String userName;
    private String userPassword;
    public List<Integer> saved_restaurants;
    public List<Integer> userRegister_themeIds;
    public List<Integer> user_heart_reviewIds;

    public User() {
    }

    @JsonCreator
    @Builder
    public User(@JsonProperty("userId") String userId,
                @JsonProperty("userName")String userName,
                @JsonProperty("userPassword") String userPassword,
                @JsonProperty("saved_restaurants") List<Integer> saved_restaurants,
                @JsonProperty("userRegister_themeIds") List<Integer> userRegister_themeIds,
                @JsonProperty("user_heart_reviewIds") List<Integer> user_heart_reviewIds) {

        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.saved_restaurants = saved_restaurants;
        this.userRegister_themeIds = userRegister_themeIds;
        this.user_heart_reviewIds = user_heart_reviewIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public List<Integer> getSaved_restaurants() {
        return saved_restaurants;
    }

    public List<Integer> getUserRegister_themeIds() {
        return userRegister_themeIds;
    }

    public List<Integer> getUser_heart_reviewIds() {
        return user_heart_reviewIds;
    }

    public void setSaved_restaurants(List<Integer> saved_restaurants) {
        this.saved_restaurants = saved_restaurants;
    }

    public void setUserRegister_themeIds(List<Integer> userRegister_themeIds) {
        this.userRegister_themeIds = userRegister_themeIds;
    }

    public void setUser_heart_reviewIds(List<Integer> user_heart_reviewIds) {
        this.user_heart_reviewIds = user_heart_reviewIds;
    }
}