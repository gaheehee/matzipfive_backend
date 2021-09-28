package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

// user가 등록한 테마id

@Entity(name = "userregisterthemeids")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRegisterThemeIds {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "theme_id")
    private Integer themeId;

    @JsonCreator
    @Builder
    public UserRegisterThemeIds(@JsonProperty("id") Integer id,
                                @JsonProperty("user_id") String userId,
                                @JsonProperty("theme_id") Integer themeId) {
        this.id = id;
        this.userId = userId;
        this.themeId = themeId;
    }
}
