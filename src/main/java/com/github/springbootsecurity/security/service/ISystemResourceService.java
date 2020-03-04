package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午10:15 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemResourceService {

    /**
     * 获取所有的资源
     *
     * @return List
     */
    List<SystemResourceDO> findAllResource();

    /**
     * 根据url和 method 获取资源
     *
     * @param url    url
     * @param method method
     * @return SystemResourceDO
     */
    SystemResourceDO findOneByUrlAndMethod(String url, String method);

}
