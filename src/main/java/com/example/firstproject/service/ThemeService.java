package com.example.firstproject.service;

import com.example.firstproject.model.Theme;
import com.example.firstproject.model.ThemeCardIds;
import com.example.firstproject.repository.CardRepository;
import com.example.firstproject.repository.ThemeCardIdsRepository;
import com.example.firstproject.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    ThemeCardIdsRepository themeCardIdsRepository;
    @Autowired
    CardRepository cardRepository;

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

    public void modifyTheme(Integer themeId, Theme theme) {
        themeRepository.save(theme);
    }

    public void removeTheme(Integer themeId) {
        //해당 테마 정보 삭제
        themeRepository.deleteById(themeId);
        //해당 테마에 등록된 카드들 정보 삭제
        //themeCardIdsRepository.deleteAllByThemeId(themeId);

    }

    // 해당 테마 안의 카드들 정보
    public List<ThemeCardIds> getAllCardsByThemeId(Integer themeId) {
        List<ThemeCardIds> themeCardIds = themeCardIdsRepository.findAllByThemeId(themeId);
        return themeCardIds;
    }
}
