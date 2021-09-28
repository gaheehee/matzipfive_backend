package com.example.firstproject.controller;

import com.example.firstproject.model.Theme;
import com.example.firstproject.model.ThemeCardIds;
import com.example.firstproject.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("")
    public List<Theme> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/{themeId}")
    public Theme getThemeByThemeId(@PathVariable Integer themeId) {
        return themeService.getThemeByThemeId(themeId);
    }

    // 해당 테마 안의 카드들 정보
    @GetMapping("/CardsInTheme/{themeId}")
    public List<ThemeCardIds> getAllCardsByThemeId(@PathVariable Integer themeId){
        return themeService.getAllCardsByThemeId(themeId);
    }

    @PostMapping("")
    @ResponseBody   // 이거 없어도 되나?
    public Theme registerTheme(@RequestBody Theme theme) {
        return themeService.registerTheme(theme);
    }

    @PutMapping("/{themeId}")
    public void modifyTheme(@PathVariable Integer themeId, @RequestBody Theme theme) {
        themeService.modifyTheme(themeId, theme);
    }

    @DeleteMapping("/{themeId}")
    public void removeTheme(@PathVariable Integer themeId) {
        themeService.removeTheme(themeId);
    }
}
