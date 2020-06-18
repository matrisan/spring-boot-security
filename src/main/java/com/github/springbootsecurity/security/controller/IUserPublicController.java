package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.constraint.RetrieveType;
import com.github.springbootsecurity.security.pojo.dto.RetrievePasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.RetrieveMessageVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

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


    /**
     * 找回密码
     *
     * @param type     类型
     * @param retrieve 找回信息
     * @return RetrieveMessageVO
     */
    ResultVO<RetrieveMessageVO> retrievePassword(@RetrieveType String type, @RequestBody RetrievePasswordDTO retrieve);

//    ResultVO<Void> resetPassword();
}
