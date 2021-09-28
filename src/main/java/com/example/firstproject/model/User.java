package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;


//@Table(name = "user")
@Entity(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;


    @JsonCreator
    @Builder
    public User(@JsonProperty("user_id") String userId,
                @JsonProperty("user_name")String userName,
                @JsonProperty("user_password") String userPassword) {

        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserPassword() { return userPassword; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

}