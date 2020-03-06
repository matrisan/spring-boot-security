package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午8:03 2020/2/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemRoleRepository extends JpaRepository<SystemRoleDO, Long> {

    Optional<SystemRoleDO> findByRoleNameEquals(String roleName);

    boolean existsByRoleNameEquals(String roleName);

    Page<SystemRoleDO> findAllByRoleNameIn(Set<String> roleNames, Pageable pageable);

    Page<SystemRoleDO> findAllByRoleIdIn(Set<Long> roleIds, Pageable pageable);

}
