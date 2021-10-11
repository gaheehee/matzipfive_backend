package com.example.firstproject.controller;

import com.example.firstproject.service.CardService;
import com.example.firstproject.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CardController.class) // Rest API를 테스트를 위해 WebMvc 추가
@DisplayName("CardController 테스트")
public class CardControllerTest {

    @MockBean
    private CardService cardService;

    @Autowired
    private MockMvc mvc;

    //private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void urlTest() throws Exception{
        mvc.perform(get("/cards"))
                .andExpect(status().isOk());
    }
}
