package com.github.springbootsecurity.security.pojo.mapper;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;

/**
 * @author 石少东
 * @date 2020-06-04 16:57
 */

public class SystemUserMapper {

    public static @NotNull SystemUserDO mapper(SystemUserDTO dto) {
        SystemUserDO user = new SystemUserDO();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

}
