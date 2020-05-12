package com.github.springbootsecurity.security.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午11:00 2020/5/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -9016572856407681481L;

    private Integer status;

    private T data;

    private String message;

    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder().status(200).build();
    }

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder().status(200).data(data).build();
    }

    public static <T> ResultVO<T> success(T data, String message) {
        return ResultVO.<T>builder().status(200).data(data).message(message).build();
    }

    public static <T> ResultVO<T> failure() {
        return ResultVO.<T>builder().status(500).build();
    }

    public static <T> ResultVO<T> failure(String message) {
        return ResultVO.<T>builder().status(500).message(message).build();
    }

}
