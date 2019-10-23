package com.github.springbootsecurity.repository;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 上午10:58 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemRoleJpaRepository extends JpaRepository<SystemRoleDO, Long> {
}
