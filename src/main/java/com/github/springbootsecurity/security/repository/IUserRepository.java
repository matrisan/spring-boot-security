package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

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

public interface IUserRepository extends JpaRepository<SystemUserDO, Long> {

    /**
     * 查找所有的用户
     *
     * @param pageable 分页
     * @param clz      泛型
     * @param <V>      泛型
     * @return Page
     */
    <V> Page<V> findAllBy(Pageable pageable, Class<V> clz);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @param clz      泛型
     * @param <V>      泛型
     * @return Optional
     */
    <V> Optional<V> findByUsernameEquals(String username, Class<V> clz);


    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return SystemUserDO
     */
    SystemUserDO findByUsernameEquals(String username);

    /**
     * 更新用户最后登录时间
     */
    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query("UPDATE SystemUserDO AS user SET user.lastLoginDate = current_date WHERE user.id = :#{principal.username}")
    void updateLastLoginDate();
}
