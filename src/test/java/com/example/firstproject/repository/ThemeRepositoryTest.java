package com.example.firstproject.repository;

import com.example.firstproject.model.Theme;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ThemeRepositoryTest {

    @Autowired
    private ThemeRepository themeRepository;

    @Test
    public void saveThemeTest (){

        // given
        final Theme theme = Theme.builder()
                .userId("jghgahee")
                .themeName("good theme")
                .cardNum(0)
                .build();

        // when
        final Theme savedTheme = themeRepository.save(theme);

        // then
        assertEquals("jghgahee", savedTheme.getUserId());
        assertEquals("good theme", savedTheme.getThemeName());
        assertEquals(0, savedTheme.getCardNum());
    }
}
