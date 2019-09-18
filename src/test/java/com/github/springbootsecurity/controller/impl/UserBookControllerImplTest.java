package com.github.springbootsecurity.controller.impl;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * 创建时间为 下午12:33 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserBookControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @WithMockUser(roles = "USER", username = "user")
    @SneakyThrows(Exception.class)
    @Test
    public void getBookByBookName() {
        mockMvc.perform(MockMvcRequestBuilders.get("/book/java"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @WithMockUser(roles = "ROOT")
    @SneakyThrows(Exception.class)
    @Test
    public void getAllBooks() {
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}