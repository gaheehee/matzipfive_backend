package com.example.firstproject.repository;

import com.example.firstproject.model.Card;
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
        final Card card = Card.builder()
                .createdAt("createdAt")
                .build();

        // when
        final Card savedCard = cardRepository.save(card);

        // then
        assertEquals("createdAt", savedCard.getCreatedAt());
    }
}
