package com.example.firstproject.service;

import com.example.firstproject.model.Theme;
//import com.example.firstproject.model.ThemeCard;
import com.example.firstproject.repository.CardRepository;
//import com.example.firstproject.repository.ThemeCardRepository;
import com.example.firstproject.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    ThemeRepository themeRepository;
    /*@Autowired
    ThemeCardRepository themeCardRepository;*/
    @Autowired
    CardRepository cardRepository;

    public List<Theme> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themes;
    }

    public Theme getThemeByThemeId(Integer themeId) {
        return themeRepository.getById(themeId);

    }

    // 해당 user가 등록한 테마들 가져오기
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
    /*public List<ThemeCard> getAllCardsByThemeId(Integer themeId) {
        List<ThemeCard> themeCard = themeCardRepository.findAllByThemeId(themeId);
        return themeCard;
    }*/
}
