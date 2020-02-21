package com.github.springbootsecurity.application.repository;

import com.github.springbootsecurity.application.pojo.AppBookDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 创建时间为 下午1:00 2020/2/20
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface AppBookRepository extends JpaRepository<AppBookDO, Long> {

}
