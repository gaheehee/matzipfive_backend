package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

// user가 등록한 테마id

@Entity(name = "user_registered_theme")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRegisteredTheme {

    @Id
    @Column(name = "theme_id")
    private Integer themeId;
    @Column(name = "user_id")
    private String userId;

    @JsonCreator
    @Builder
    public UserRegisteredTheme(
            @JsonProperty("user_id") String userId,
            @JsonProperty("theme_id") Integer themeId) {
        this.userId = userId;
        this.themeId = themeId;
    }
}
