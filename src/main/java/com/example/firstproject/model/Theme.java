package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@Entity(name = "theme")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Theme {

    @Id
    @Column(name = "theme_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer themeId;
    @Column(name = "theme_name")
    private String themeName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "card_num")
    private Integer cardNum;


    @JsonCreator
    @Builder
    public Theme(@JsonProperty("theme_id") Integer themeId,
                 @JsonProperty("theme_name") String themeName,
                 @JsonProperty("user_id") String userId,
                 @JsonProperty("card_num") Integer cardNum) {

        this.themeId = themeId;
        this.themeName = themeName;
        this.userId = userId;
        this.cardNum = cardNum;
    }

}
