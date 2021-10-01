package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;


@Entity(name = "user")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
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

}