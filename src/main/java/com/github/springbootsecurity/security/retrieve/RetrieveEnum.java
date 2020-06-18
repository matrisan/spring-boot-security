package com.github.springbootsecurity.security.retrieve;

import lombok.Getter;

/**
 * @author 石少东
 * @date 2020-06-18 15:27
 * @since 1.0
 */


public enum RetrieveEnum {

    MOBILE("mobile"),
    EMAIL("email");

    @Getter
    private String type;

    RetrieveEnum(String type) {
    }
}
