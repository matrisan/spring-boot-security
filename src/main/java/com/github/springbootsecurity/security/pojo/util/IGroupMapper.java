package com.github.springbootsecurity.security.pojo.util;

import com.github.springbootsecurity.security.pojo.orm.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.vo.SystemGroupVO;
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
public interface IGroupMapper {

    /**
     * 将组织架构的 DO 转成 VO
     *
     * @param group 组织架构信息
     * @return SystemGroupVO
     */
    SystemGroupVO converter(SystemGroupDO group);

}
