package com.github.springbootsecurity.security.pojo.dto;

import com.github.springbootsecurity.security.validation.constraints.Username;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 上午11:07 2020/3/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RetrieveDTO implements Serializable {

    private static final long serialVersionUID = -8416013071528591211L;

    @Username
    private String username;

}
