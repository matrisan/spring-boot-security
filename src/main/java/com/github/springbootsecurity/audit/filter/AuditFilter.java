package com.github.springbootsecurity.audit.filter;

import com.github.springbootsecurity.audit.pojo.AuditLogDO;
import com.github.springbootsecurity.audit.repository.AuditLogRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午4:35 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Order(Integer.MIN_VALUE)
@Component
public class AuditFilter extends OncePerRequestFilter {

    @Resource
    private AuditLogRepository repository;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrapperRequest = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(response);
        AuditLogDO operation = AuditLogDO.builder()
                .method(wrapperRequest.getMethod())
                .path(wrapperRequest.getRequestURI())
                .build();
        try {
            filterChain.doFilter(wrapperRequest, wrapperResponse);
        } catch (Exception e) {
            operation.setExceptionMessage(ExceptionUtils.getMessage(e));
            throw e;
        } finally {
            operation.setStatus(wrapperResponse.getStatus());
            operation.setRequestBody(StringUtils.deleteWhitespace(new String(wrapperRequest.getContentAsByteArray())));
            operation.setResponseBody(StringUtils.deleteWhitespace(new String(wrapperResponse.getContentAsByteArray())));
            operation = repository.save(operation);
            System.out.println(operation.toString());
            wrapperResponse.copyBodyToResponse();
        }
    }

}
