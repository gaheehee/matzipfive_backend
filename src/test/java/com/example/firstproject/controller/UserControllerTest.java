package com.example.firstproject.controller;

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
@WebMvcTest(controllers = UserController.class) // Rest API를 테스트를 위해 WebMvc 추가
@DisplayName("UserController 테스트")
class UserControllerTest {

    // UserController에서 사용하는 Service
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mvc;

    //private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void urlTest() throws Exception{
        mvc.perform(get("/users"))
                .andExpect(status().isOk());
    }


}
