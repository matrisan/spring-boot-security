package com.github.springbootsecurity.security.controller.manager.impl;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserCenterControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @WithMockUser(roles = "ROOT", username = "root")
    @Test
    public void me() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/center/me"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(200))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @WithMockUser(roles = "ROOT", username = "root")
    @Test
    public void updateUserInfo() throws Exception {
    }

    @WithMockUser(roles = "ROOT", username = "root")
    @Test
    public void resetPassword() throws Exception {
    }
}