package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import org.springframework.validation.annotation.Validated;

/**
 * @author 石少东
 * @date 2020-06-16 17:08
 */

public interface IUserPublicController<T extends UserRegisterDTO> {

    /**
     * 注册用户
     *
     * @param register 注册信息
     * @return Void
     */
    ResultVO<Void> register(@Validated T register);

}
