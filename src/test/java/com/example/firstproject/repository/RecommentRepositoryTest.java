package com.example.firstproject.repository;

import com.example.firstproject.model.Recomment;
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
public class RecommentRepositoryTest {

    @Autowired
    private RecommentRepository recommentRepository;

    @Test
    public void saveRecommentTest(){

        // given
        final Recomment recomment = Recomment.builder()
                .userId("jghgahee")
                .content("bbb")
                .createdAt("createdAt")
                .build();

        // when
        final Recomment savedRecomment = recommentRepository.save(recomment);

        // then
        assertEquals("jghgahee", savedRecomment.getUserId());
        assertEquals("bbb", savedRecomment.getContent());
        assertEquals("createdAt", savedRecomment.getCreatedAt());
    }
}
