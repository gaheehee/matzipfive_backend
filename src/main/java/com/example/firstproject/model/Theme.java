package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity(name = "theme")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Theme {

    @Id
    @Column(name = "theme_id")
    private Integer themeId;
    @Column(name = "theme_name")
    private String themeName;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "card_num")
    private Integer card_num;


    // request mapping을 통해 Json으로 받은 RequestBody를 rest Api 프로젝트의 dto객체 형식으로 변경할 수 있음

    @JsonCreator
    @Builder
    public Theme(@JsonProperty("theme_id") Integer themeId,
                 @JsonProperty("theme_name") String themeName,
                 @JsonProperty("user_id") String userId,
                 @JsonProperty("card_num") Integer card_num) {

        this.themeId = themeId;
        this.themeName = themeName;
        this.userId = userId;
        this.card_num = card_num;
    }

    public Integer getThemeId(){
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCard_num() {
        return card_num;
    }

    public void setCard_num(Integer card_num) {
        this.card_num = card_num;
    }

}
