package com.github.springbootsecurity.security.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-06-16 18:50
 */

@RequiredArgsConstructor
public class PasswordConverter implements AttributeConverter<String, String> {

    private final PasswordEncoder encoder;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return encoder.encode(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
