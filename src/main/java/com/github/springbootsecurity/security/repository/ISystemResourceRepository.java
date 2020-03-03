package com.github.springbootsecurity.security.repository;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
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

public interface ISystemResourceRepository extends JpaRepository<SystemResourceDO, Long> {

    List<SystemResourceDO> findAllByUrlNotNullAndMethodEquals(String method);

    Optional<SystemResourceDO> findByUrlEqualsAndMethodEquals(String url, String method);

    Page<SystemResourceDO> findAllByUrlIn(Set<String> set, Pageable pageable);

    boolean existsByUrlEqualsAndMethodEquals(String url, String method);

    List<SystemResourceDO> findAllByUrlStartsWith(String starts);
}
