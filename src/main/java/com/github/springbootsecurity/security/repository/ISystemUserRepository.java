package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
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

public interface ISystemUserRepository extends JpaRepository<SystemUserDO, Long> {

    Optional<SystemUserDO> findSystemUserDOByUsernameEquals(String username);

    Optional<SystemUserDO> findByUsernameEquals(String username);

    boolean existsByUsernameEquals(String username);

    Page<SystemUserDO> findAllByUsernameIn(Set<String> usernames, Pageable pageable);


}
