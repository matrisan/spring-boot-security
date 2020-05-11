package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.orm.SystemGroupDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午3:21 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemGroupJpaRepository extends JpaRepository<SystemGroupDO, Long> {
}
