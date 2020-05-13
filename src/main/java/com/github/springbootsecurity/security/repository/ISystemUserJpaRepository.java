package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

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

public interface ISystemUserJpaRepository extends JpaRepository<SystemUserDO, Long> {

    SystemUserDO findByUsernameEquals(String username);

    SystemUserDO findSystemUserDOByUsernameIs(String username);

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("UPDATE SystemUserDO AS user SET user.lastLoginDate = current_date WHERE user = ?1")
    void updateLastLoginDate(SystemUserDO user);

}
