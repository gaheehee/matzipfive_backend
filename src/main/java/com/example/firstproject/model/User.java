package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    private String userId;
    @Column
    private String userName;
    @Column
    private String userPassword;
    @Transient
    public List<Integer> savedRestaurants;
    @Transient
    public List<Integer> userRegisterThemeIds;
    @Transient
    public List<Integer> userHeartReviewIds;

    public User() {
    }

    @JsonCreator
    @Builder
    public User(@JsonProperty("userId") String userId,
                @JsonProperty("userName")String userName,
                @JsonProperty("userPassword") String userPassword,
                @JsonProperty("savedRestaurants") List<Integer> savedRestaurants,
                @JsonProperty("userRegisterThemeIds") List<Integer> userRegisterThemeIds,
                @JsonProperty("userHeartReviewIds") List<Integer> userHeartReviewIds) {

        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.savedRestaurants = savedRestaurants;
        this.userRegisterThemeIds = userRegisterThemeIds;
        this.userHeartReviewIds = userHeartReviewIds;
    }

    /*public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public List<Integer> getSavedRestaurants() {
        return savedRestaurants;
    }

    public List<Integer> getUserRegisterThemeIds() {
        return userRegisterThemeIds;
    }

    public List<Integer> getUserHeartReviewIds() {
        return userHeartReviewIds;
    }

    public void setSavedRestaurants(List<Integer> savedRestaurants) {
        this.savedRestaurants = savedRestaurants;
    }

    public void setUserRegisterThemeIds(List<Integer> userRegisterThemeIds) {
        this.userRegisterThemeIds = userRegisterThemeIds;
    }

    public void setUserHeartReviewIds(List<Integer> userHeartReviewIds) {
        this.userHeartReviewIds = userHeartReviewIds;
    }*/
}