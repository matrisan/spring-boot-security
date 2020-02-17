//package com.github.springbootsecurity.controller.application.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
//import com.github.springbootsecurity.pojo.dto.SystemUserDTO;
//import com.google.common.collect.Sets;
//import lombok.SneakyThrows;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import javax.annotation.Resource;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * <p>
// * 创建时间为 下午4:38 2019/10/18
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@AutoConfigureMockMvc
//@ActiveProfiles("junit")
//@RunWith(SpringRunner.class)
//@WithMockUser(roles = "ROOT", username = "root")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class RootSystemUserControllerImplTest {
//
//    @Resource
//    private MockMvc mockMvc;
//
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void findAllUsers() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/root/user"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.totalElements").value(0))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void saveUser() {
//        mockMvc.perform(MockMvcRequestBuilders.post("/root/center/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JSON.toJSONString(getUserInfo())))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void updateUser() {
//        mockMvc.perform(MockMvcRequestBuilders.post("/root/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JSON.toJSONString(getUserInfo())))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    @SneakyThrows(Exception.class)
//    public void deleteUser() {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/root/user/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    private SystemUserDTO getUserInfo() {
//        return SystemUserDTO.builder()
//                .username("TestUser4")
//                .password("111111")
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .credentialsNonExpired(true)
//                .roles(Sets.newHashSet(1L, 2L))
////                .roles(Sets.newHashSet(SystemRoleDO.builder().roleId(2L).build()))
//                .enabled(true)
//                .note("user_all")
//                .build();
//
//    }
//
//}