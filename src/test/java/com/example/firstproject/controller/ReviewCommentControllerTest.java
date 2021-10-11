package com.example.firstproject.controller;

import com.example.firstproject.service.ReviewCommentService;
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
@WebMvcTest(controllers = ReviewCommentController.class) // Rest API를 테스트를 위해 WebMvc 추가
@DisplayName("ReviewCommentController 테스트")
public class ReviewCommentControllerTest {

    @MockBean
    private ReviewCommentService reviewCommentService;

    @Autowired
    private MockMvc mvc;

    //private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void urlTest() throws Exception{
        mvc.perform(get("/reviewComments"))
                .andExpect(status().isOk());
    }
}
