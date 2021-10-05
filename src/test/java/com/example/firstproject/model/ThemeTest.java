package com.example.firstproject.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThemeTest {

    @Test
    public void lombokTest() {
        // given
        Integer themeId = 64;
        String themeName = "mu";
        String userId = "gahee";
        Integer cardNum = 5;

        // when
        Theme theme = new Theme(themeId, themeName, userId, cardNum);

        // then
        assertThat(theme.getThemeId()).isEqualTo(themeId);
        assertThat(theme.getThemeName()).isEqualTo(themeName);
        assertThat(theme.getUserId()).isEqualTo(userId);
        assertThat(theme.getCardNum()).isEqualTo(cardNum);
    }
}
