package com.github.springbootsecurity.security.core.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-08-02 01:35
 * @since 1.0
 */

@Slf4j
@Component
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        // ...
        log.info("AuthenticationSuccessEvent");
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
        // ...
        log.info("AbstractAuthenticationFailureEvent");
    }
}