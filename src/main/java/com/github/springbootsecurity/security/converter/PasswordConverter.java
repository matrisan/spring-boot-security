package com.github.springbootsecurity.security.converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (StringUtils.isNotBlank(attribute)) {
            return encoder.encode(attribute);
        }
        return "";
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }


}
