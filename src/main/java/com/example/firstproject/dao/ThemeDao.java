package com.example.firstproject.dao;

import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ThemeDao {

    public static List<Theme> themes;

    static {
        themes = new ArrayList<>();
        themes.add(new Theme(1, "theme1","userId1", 4));
        themes.add(new Theme(2,"theme2","userId2", 5));
        themes.add(new Theme(3,"theme3","userId3", 3));
    }

    public List<Theme> getAllThemes() { return themes;}

    public Theme getThemeByThemeId(Integer themeId) {
        return themes
                .stream()
                .filter(theme -> theme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1 , "", "", -1 ));
    }

    public Theme getThemeByUserId(String userId) {
        return themes
                .stream()
                .filter(theme -> theme.getUserId().equals(userId))
                .findAny()
                .orElse(new Theme(-1, "", "", -1));
    }

    public Theme insertTheme(Theme theme) {
        themes.add(theme);
        return theme;
    }

    public void updateTheme(Integer themeId, Theme theme) {
        themes.stream()
                .filter(curTheme -> curTheme.getThemeId().equals(themeId))
                .findAny()
                .orElse(new Theme(-1, "","",-1))
                .setThemeName(theme.getThemeName());
    }

    public void deleteTheme(Integer themeId) {
        themes.removeIf(theme -> theme.getThemeId().equals(themeId));
    }

}
