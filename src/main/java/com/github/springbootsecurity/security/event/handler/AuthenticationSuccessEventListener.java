package com.github.springbootsecurity.security.event.handler;

import com.github.springbootsecurity.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午11:19 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationSuccessEventListener {

    private final IUserRepository repository;

    @EventListener
    public void authenticationSuccessEvent(@NotNull AuthenticationSuccessEvent event) {
        repository.updateLastLoginDate();
    }

}
