package com.example.firstproject.service;

import com.example.firstproject.dao.ThemeDao;
import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeDao themeDao;

    public List<Theme> getAllThemes() {
        return themeDao.getAllThemes();
    }

    public Theme getThemeByThemeId(Integer themeId) {
        return themeDao.getThemeByThemeId(themeId);
    }

    public Theme getThemeByUserId(String userId) {
        return themeDao.getThemeByUserId(userId);
    }

    public Theme registerTheme(Theme theme) {
        return themeDao.insertTheme(theme);
    }

    public void modifyTheme(Integer themeId, Theme theme) {
        themeDao.updateTheme(themeId, theme);
    }

    public void removeTheme(Integer themeId) {
        themeDao.deleteTheme(themeId);
    }

}
