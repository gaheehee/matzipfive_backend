package com.example.firstproject.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CardTest {

    @Test
    public void lombokTest(){
        // given
        Integer cardId= 18;
        String createdAt = "yyyy'년' MM'월' dd'일', a hh:mm";

        // when
        User user = new User("gahee", "userName", "userPassword");
        Theme theme = new Theme(8, "themeName", "userId", 6);
        Card card = new Card(cardId, createdAt);
        card.setUser(user);
        card.setTheme(theme);

        // then
        assertThat(card.getCardId()).isEqualTo(cardId);
        assertThat(card.getCreatedAt()).isEqualTo(createdAt);
        assertThat(card.getUser()).isEqualTo(user);
        assertThat(card.getTheme()).isEqualTo(theme);
    }
}
