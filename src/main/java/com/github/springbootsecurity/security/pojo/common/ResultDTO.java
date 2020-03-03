package com.github.springbootsecurity.security.pojo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午1:59 2020/2/26
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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 6017031786836834798L;

    private Integer status;

    private String message;

    private T data;

    public static <T> ResultDTO<T> success() {
        return ResultDTO.<T>builder().status(200).message("执行成功").build();
    }

    public static <T> ResultDTO<T> success(String message) {
        return ResultDTO.<T>builder().status(200).message(message).build();
    }

    public static <T> ResultDTO<T> success(T data) {
        return ResultDTO.<T>builder().status(200).message("执行成功").data(data).build();
    }

    public static <T> ResultDTO<T> success(String message, T data) {
        return ResultDTO.<T>builder().status(200).message(message).data(data).build();
    }

    public static <T> ResultDTO<T> failure() {
        return ResultDTO.<T>builder().message("执行失败").status(400).build();
    }

    public static <T> ResultDTO<T> failure(String message) {
        return ResultDTO.<T>builder().message(message).status(400).build();
    }

    public static <T> ResultDTO<T> failure(String message, T data) {
        return ResultDTO.<T>builder().message(message).status(400).data(data).build();
    }

}
