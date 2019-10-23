package com.github.springbootsecurity.controller.security.impl;

import lombok.SneakyThrows;
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
 * 创建时间为 下午3:30 2019/9/18
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
public class UserRootControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @WithMockUser(roles = "USER", username = "user")
    @SneakyThrows(Exception.class)
    @Test
    public void findAllUsers() {
        mockMvc.perform(MockMvcRequestBuilders.get("/root/users"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @WithMockUser(roles = "USER", username = "user")
    @SneakyThrows(Exception.class)
    @Test
    public void findAllRoles() {
        mockMvc.perform(MockMvcRequestBuilders.get("/root/roles"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @WithMockUser(roles = "USER", username = "user")
    @SneakyThrows(Exception.class)
    @Test
    public void findAllBooks() {
        mockMvc.perform(MockMvcRequestBuilders.get("/root/books"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }
}