package com.example.firstproject.controller;

import com.example.firstproject.model.Theme;
//import com.example.firstproject.model.ThemeCard;
import com.example.firstproject.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    public ThemeController() {
    }

    @GetMapping("")
    public List<Theme> getAllThemes() {
        return themeService.getAllThemes();
    }

    //해당 테마 정보 가져오기
    @GetMapping("/{themeId}")
    public Theme getThemeByThemeId(@PathVariable Integer themeId) {
        return themeService.getThemeByThemeId(themeId);
    }

    // 해당 user가 등록한 테마들 가져오기
    @GetMapping("themesByUser/{userId}")
    public List<Theme> getThemeByUserId(@PathVariable String userId){
        return themeService.getThemeByUserId(userId);
    }

    //새 테마 생성
    @PostMapping("")
    public Theme registerTheme(@RequestBody Theme theme) {
        return themeService.registerTheme(theme);
    }

    //테마 정보 변경 -> 쓰일 일이 없을듯
    @PutMapping("/{themeId}")
    public void modifyTheme(@PathVariable Integer themeId, @RequestBody Theme theme) {
        themeService.modifyTheme(themeId, theme);
    }

    //테마 삭제
    @DeleteMapping("/{themeId}")
    public void removeTheme(@PathVariable Integer themeId) {
        themeService.removeTheme(themeId);
    }

    //해당 테마에 등록된 카드id 정보 가져오기
    /*@GetMapping("/CardsInTheme/{themeId}")
    public List<ThemeCard> getAllCardsByThemeId(@PathVariable Integer themeId){
        return themeService.getAllCardsByThemeId(themeId);
    }*/
}
