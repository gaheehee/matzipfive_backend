package com.example.firstproject.dao;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThemeDao {

    public static List<Integer> theme_cardIds_1;
    public static List<Integer> theme_cardIds_2;
    public static List<Integer> theme_cardIds_3;

    static{
        theme_cardIds_1 = new ArrayList<>();
        theme_cardIds_1.add(1); theme_cardIds_1.add(2); theme_cardIds_1.add(3);
    }
    static{
        theme_cardIds_2 = new ArrayList<>();
        theme_cardIds_2.add(1); theme_cardIds_2.add(2); theme_cardIds_2.add(3);
    }
    static{
        theme_cardIds_3 = new ArrayList<>();
        theme_cardIds_3.add(1); theme_cardIds_3.add(2); theme_cardIds_3.add(3);
    }


    public static List<Theme> themes;

    static {
        themes = new ArrayList<>();
        themes.add(new Theme(1, "theme1","userId1", 4, theme_cardIds_1));
        themes.add(new Theme(2,"theme2","userId2", 5, theme_cardIds_2));
        themes.add(new Theme(3,"theme3","userId3", 3, theme_cardIds_3));
    }

    public List<Theme> getAllThemes() { return themes;}

    public Theme getThemeByThemeId(Integer themeId) {
        return themes
                .stream()
                .filter(theme -> theme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1 , "", "", -1 ,null));
    }

    public Theme getThemeByUserId(String userId) {
        return themes
                .stream()
                .filter(theme -> theme.getUserId().equals(userId))
                .findAny()
                .orElse(new Theme(-1, "", "", -1,null));
    }

    public Theme insertTheme(Theme theme) {
        themes.add(theme);
        return theme;
    }

    public void updateTheme(Integer themeId, Theme theme) {
        // 테마 이름 수정 업뎃
        themes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setThemeName(theme.getThemeName());

        // 카드 추가, 삭제..?
        themes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setTheme_cardIds(theme.getTheme_cardIds());

        // 테마안의 카드 수 없뎃 -> 카드 삭제나 추가 시
        themes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setCard_num(theme.getCard_num());

    }

    public void deleteTheme(Integer themeId) {
        themes.removeIf(theme -> theme.getThemeId().equals(themeId));
    }

}
