package com.github.springbootsecurity.controller.application.impl;

import com.alibaba.fastjson.JSON;
import com.github.springbootsecurity.pojo.doo.UserBookDO;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

/**
 * <p>
 * 创建时间为 下午4:04 2019/10/18
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
public class BookManagementControllerImplTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @SneakyThrows(Exception.class)
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void findAllBooks() {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(0))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @SneakyThrows(Exception.class)
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void saveBook() {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(getUserBook())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @SneakyThrows(Exception.class)
    @WithMockUser(roles = "ADMIN", username = "admin")
    public void updateBook() {
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(getUserBook())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @WithMockUser(roles = "ADMIN", username = "admin")
    @SneakyThrows(Exception.class)
    @Test
    public void deleteBookById() {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/book/2").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    private UserBookDO getUserBook() {
        return UserBookDO.builder()
                .name("Java")
                .note("TestName")
                .build();
    }

}