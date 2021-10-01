package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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


    //@ManyToOne
    //@JoinColumn(name = "user_id")
    //private User user;

    //@OneToMany(mappedBy = "theme")
    //private List<Card> cards =new ArrayList<>();

    // request mapping을 통해 Json으로 받은 RequestBody를 rest Api 프로젝트의 dto객체 형식으로 변경할 수 있음

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
