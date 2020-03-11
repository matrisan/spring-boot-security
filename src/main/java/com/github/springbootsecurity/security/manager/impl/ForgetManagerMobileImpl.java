package com.github.springbootsecurity.security.manager.impl;

import com.github.springbootsecurity.security.manager.AbstractForgetManager;
import com.github.springbootsecurity.security.pojo.bo.MessageBO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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

@Service("mobile")
public class ForgetManagerMobileImpl extends AbstractForgetManager {

    @Override
    public void sentMessage(SystemUserDO systemUser, @NotNull MessageBO message) {
        System.out.println(message.toString());
    }
}
