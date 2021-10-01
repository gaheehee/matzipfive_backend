package com.example.firstproject.service;

import com.example.firstproject.model.Theme;
import com.example.firstproject.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeRepository themeRepository;


    public List<Theme> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themes;
    }

    public Theme getThemeByThemeId(Integer themeId) {
        return themeRepository.getById(themeId);

    }

    public List<Theme> getThemeByUserId(String userId) {
        List<Theme> themes = themeRepository.findAllByUserId(userId);
        return themes;
    }

    public Theme registerTheme(Theme theme) {
        themeRepository.save(theme);
        return theme;
    }

    public void modifyTheme(Theme theme) {
        themeRepository.save(theme);
    }

    public void removeTheme(Integer themeId) {
        themeRepository.deleteById(themeId);
    }

}
