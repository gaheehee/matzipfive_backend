package com.example.firstproject.dao;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThemeDao {

    public static List<Integer> MockThemeCardIds = new ArrayList<>();
    { MockThemeCardIds.add(1); MockThemeCardIds.add(2); MockThemeCardIds.add(3); }



    public List<Theme> MockThemes = new ArrayList<>();

    {
        MockThemes.add(new Theme(1, "theme1","userId1", 4, MockThemeCardIds));
        MockThemes.add(new Theme(2,"theme2","userId2", 5, MockThemeCardIds));
        MockThemes.add(new Theme(3,"theme3","userId3", 3, MockThemeCardIds));
    }

    public List<Theme> getAllThemes() { return MockThemes;}

    public Theme getThemeByThemeId(Integer themeId) {
        return MockThemes
                .stream()
                .filter(theme -> theme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1 , "", "", -1 ,null));
    }

    public Theme getThemeByUserId(String userId) {
        return MockThemes
                .stream()
                .filter(theme -> theme.getUserId().equals(userId))
                .findAny()
                .orElse(new Theme(-1, "", "", -1,null));
    }

    public Theme insertTheme(Theme theme) {
        MockThemes.add(theme);
        return theme;
    }

    public void updateTheme(Integer themeId, Theme theme) {
        // 테마 이름 수정 업뎃
        MockThemes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setThemeName(theme.getThemeName());

        // 카드 추가, 삭제..?
        MockThemes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setTheme_cardIds(theme.getTheme_cardIds());

        // 테마안의 카드 수 없뎃 -> 카드 삭제나 추가 시
        MockThemes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1,null))
                .setCard_num(theme.getCard_num());

    }

    public void deleteTheme(Integer themeId) {
        MockThemes.removeIf(theme -> theme.getThemeId().equals(themeId));
    }

}
