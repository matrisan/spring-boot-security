package com.github.springbootsecurity.security.converter;

import com.github.springbootsecurity.security.event.AppPassworddUpdateEvent;
import com.github.springbootsecurity.security.pojo.bo.UserInfoBO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-06-16 18:50
 */

@Slf4j
@RequiredArgsConstructor
public class PasswordConverter implements AttributeConverter<String, String> {

    private final PasswordEncoder encoder;

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (StringUtils.isNotBlank(attribute)) {
            String password = encoder.encode(attribute);
            pubEvent();
            return password;
        }
        return "";
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }


    private void pubEvent() {
        SystemUserDO systemUser = (SystemUserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfoBO user = new UserInfoBO();
        BeanUtils.copyProperties(systemUser, user);
        eventPublisher.publishEvent(new AppPassworddUpdateEvent(user));
        log.info("发布密码更新事件 - {}", user.getId());
    }

}
