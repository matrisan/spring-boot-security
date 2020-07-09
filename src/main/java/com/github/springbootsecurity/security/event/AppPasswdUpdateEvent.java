package com.github.springbootsecurity.security.event;

import com.github.springbootsecurity.security.pojo.bo.UserInfoBO;
import org.springframework.context.ApplicationEvent;

/**
 * @author 石少东
 * @date 2020-07-09 15:07
 * @since 1.0
 */


public class AppPasswdUpdateEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3564955735255181733L;

    public AppPasswdUpdateEvent(UserInfoBO source) {
        super(source);
    }

}
