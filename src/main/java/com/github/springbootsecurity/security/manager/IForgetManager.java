package com.github.springbootsecurity.security.manager;

import com.github.springbootsecurity.security.pojo.bo.MessageBO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;

/**
 * <p>
 * 创建时间为 下午10:37 2020/3/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IForgetManager {

    void sentMessage(SystemUserDO systemUser, MessageBO message);

}
