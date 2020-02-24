package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.SystemResourceDO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午9:42 2020/2/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemResourceService {

    List<SystemResourceDO> findAllResource();

    SystemResourceDO findOneByUrlAndMethod(String url, String method);

}
