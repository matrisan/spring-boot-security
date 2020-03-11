package com.github.springbootsecurity.security.controller.user;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.dto.PasswordRetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.RetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.service.user.ISystemMaintainService;
import com.github.springbootsecurity.security.validation.constraints.RetrieveType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午1:51 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Validated
@RestController
@PreAuthorize("permitAll()")
public class SystemMaintainController {

    @Resource
    private ISystemMaintainService service;

    @PostMapping("register")
    public ResultDTO<String> register(@RequestBody UserRegisterDTO userRegister) {
        String result = service.register(userRegister);
        return ResultDTO.success(result);
    }

    /**
     * 需求
     * 找回密码功能，
     * <p>
     * 要求，
     * 1.目前支持的方式有 短信 和 email；
     * 2.新增加新的验证方式，旧代码不修改；
     * <p>
     * 代码流程
     * 1.校验找回类型，校验用户名；
     * 2.生成临时验证码；
     * 3.存储临时验证码；
     * 4.给用户手机或者邮箱等发送临时验证码；
     * <p>
     * 分析
     * 1.所有的方式均有生成验证码动作；
     * 2.所有的方式均有存储动作；(不能存储在 Session 中)
     * 3.所有的方式均有发送动作；
     *
     * @param type     找回类型
     * @param retrieve 用户名信息
     * @return String
     */
    @GetMapping("/password/retrieve/{type}/{username}")
    public ResultDTO<String> retrieve(@RetrieveType @PathVariable String type, RetrieveDTO retrieve) {
        String result = service.retrieve(type, retrieve);
        return ResultDTO.success(result);
    }

    @PostMapping("/password/retrieve/{random}")
    public ResultDTO<String> retrieve(@PathVariable String random, @RequestBody PasswordRetrieveDTO retrieve) {
        String result = service.retrieve(random, retrieve);
        return ResultDTO.success(result);
    }

}
