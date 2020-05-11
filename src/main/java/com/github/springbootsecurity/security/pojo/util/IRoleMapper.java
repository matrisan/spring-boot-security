package com.github.springbootsecurity.security.pojo.util;

import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
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
public interface IRoleMapper {

    /**
     * 将角色 DO 转换为 VO
     *
     * @param role 角色信息
     * @return SystemRoleVO
     */
    SystemRoleVO converter(SystemRoleDO role);

}
