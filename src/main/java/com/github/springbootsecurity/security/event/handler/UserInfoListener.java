package com.github.springbootsecurity.security.event.handler;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author 石少东
 * @date 2020-06-17 19:38
 * @since 1.0
 */

@Slf4j
@Component
public class UserInfoListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void userInfoSave(@NotNull SystemUserDO userInfo) {
        log.error("userInfoSave-username:{}", userInfo.getUsername());
    }

}
