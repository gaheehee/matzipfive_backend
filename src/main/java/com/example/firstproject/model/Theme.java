package com.example.firstproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class Theme {

    private Integer themeId;
    private String themeName;
    private String userId;
    private Integer card_num;
    public List<Integer> theme_cardIds;

    // request mapping을 통해 Json으로 받은 RequestBody를 rest Api 프로젝트의 dto객체 형식으로 변경할 수 있음

    @JsonCreator
    @Builder
    public Theme(@JsonProperty("themeId") Integer themeId,
                 @JsonProperty("themeName") String themeName,
                 @JsonProperty("userId") String userId,
                 @JsonProperty("card_num") Integer card_num,
                 @JsonProperty("theme_cardIds") List<Integer> theme_cardIds) {

        this.themeId = themeId;
        this.themeName = themeName;
        this.userId = userId;
        this.card_num = card_num;
        this.theme_cardIds = theme_cardIds;
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

    public List<Integer> getTheme_cardIds() {
        return theme_cardIds;
    }

    public void setTheme_cardIds(List<Integer> theme_cardIds) {
        this.theme_cardIds = theme_cardIds;
    }
}
