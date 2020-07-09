package com.github.springbootsecurity.security.converter;

import javax.persistence.AttributeConverter;

/**
 * @author 石少东
 * @date 2020-07-09 16:46
 * @since 1.0
 */


public class MobileMosaicConverter implements AttributeConverter<String, String> {

    private static final int MOBILE_LENGTH = 11;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (null == dbData) {
            return null;
        }
        if (dbData.length() == MOBILE_LENGTH) {
            return new StringBuilder(dbData).replace(3, 7, "****").toString();
        }
        return dbData;
    }
}
