package com.github.springbootsecurity.risk.repository;

import com.github.springbootsecurity.risk.pojo.AuditLogDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>
 * 创建时间为 下午1:24 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface AuditLogRepository extends PagingAndSortingRepository<AuditLogDO, String> {
}
