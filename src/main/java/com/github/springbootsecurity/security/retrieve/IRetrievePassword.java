package com.github.springbootsecurity.security.retrieve;

import com.github.springbootsecurity.security.pojo.dto.RetrievePasswordDTO;
import com.github.springbootsecurity.security.pojo.vo.RetrieveMessageVO;

/**
 * @author 石少东
 * @date 2020-06-18 15:13
 * @since 1.0.0
 */

@FunctionalInterface
public interface IRetrievePassword {

    /**
     * 找回密码，具体实现由子类实现
     *
     * @param password 找回密码信息
     * @return RetrieveMessageVO
     */
    RetrieveMessageVO retrieve(RetrievePasswordDTO password);

}
