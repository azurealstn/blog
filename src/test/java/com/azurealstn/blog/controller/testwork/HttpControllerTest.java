package com.azurealstn.blog.controller.testwork;

import com.azurealstn.blog.controller.testwork.HttpController;
import com.azurealstn.blog.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * GET, POST, PUT, DELETE 요청 테스트
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HttpController.class)
public class HttpControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    public void Member_GET_테스트() throws Exception {
        //Member member = new Member(1L, "azure", "1234", "azure@naver.com");
        Long id = 1L;
        String username = "azure";
        String password = "1234";
        String email = "azure@naver.com";

        mvc.perform(get("/http/get")
                .param("id", String.valueOf(id))
                .param("username", username)
                .param("password", password)
                .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().string("get 요청 테스트: " + id + ", " + username + ", " + password + ", " + email))
                .andDo(print());
    }

    @Test
    public void Member_POST_테스트() throws Exception {
        String content = objectMapper.writeValueAsString(new Member(1L, "azure", "1234", "azurealstn@naver.com"));

        mvc.perform(post("/http/post")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("post 요청 테스트: " + 1L + ", " + "azure" + ", " + "1234" + ", " + "azurealstn@naver.com"))
                .andDo(print());
    }

    @Test
    public void Member_PUT_테스트() throws Exception {
        String content = objectMapper.writeValueAsString(new Member(2L, "azure12", "123456", "azurealstn@naver.com"));

        mvc.perform(put("/http/put")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("put 요청 테스트: " + 2L + ", " + "azure12" + ", " + "123456" + ", " + "azurealstn@naver.com"))
                .andDo(print());
    }

    @Test
    public void Member_DELETE_테스트() throws Exception {
        mvc.perform(delete("/http/delete"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
