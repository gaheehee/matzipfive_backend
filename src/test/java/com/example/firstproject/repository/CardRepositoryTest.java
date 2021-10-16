package com.example.firstproject.repository;

import com.example.firstproject.model.Card;
import com.example.firstproject.model.Theme;
import com.example.firstproject.model.User;
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
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void saveCardTest(){

        // given
        User user = new User("gahee", "userName", "userPassword");
        Theme theme = new Theme(8, "themeName", "userId", 6);
        final Card card = Card.builder()
                .createdAt("createdAt")
                .cardId(3)
                .theme(theme)
                .user(user)
                .build();

        // when
        final Card savedCard = cardRepository.save(card);

        // then
        assertEquals("createdAt", savedCard.getCreatedAt());
    }
}
