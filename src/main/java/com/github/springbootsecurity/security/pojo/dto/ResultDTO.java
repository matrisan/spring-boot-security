package com.github.springbootsecurity.security.pojo.dto;

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

    public static <T> ResultDTO<T> success(String message) {
        return ResultDTO.<T>builder().status(200).message(message).build();
    }


    public static <T> ResultDTO<T> success(String message, T data) {
        return ResultDTO.<T>builder().status(200).message(message).data(data).build();
    }

    public static <T> ResultDTO<T> failure(String message) {
        return ResultDTO.<T>builder().message(message).build();
    }

    public static <T> ResultDTO<T> failure(String message, T data) {
        return ResultDTO.<T>builder().message(message).data(data).build();
    }

}
