package com.github.springbootsecurity.security.pojo.util;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import org.mapstruct.Mapper;

/**
 * <p>
 * 创建时间为 下午4:21 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Mapper(componentModel = "spring")
public interface IUserMapper {

    /**
     * 将用户信息 DO 转换为 VO
     *
     * @param user 用户信息
     * @return SystemUserVO
     */
    SystemUserVO converter(SystemUserDO user);

}
