package com.github.springbootsecurity.audit.interceptor;

import com.github.springbootsecurity.audit.pojo.AuditLogDO;
import com.github.springbootsecurity.audit.repository.AuditLogRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午1:22 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class AuditLogInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private AuditLogRepository repository;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequestBodyWrapper requestBodyWrapper = new HttpServletRequestBodyWrapper(request);
        HttpServletResponseBodyWrapper responseBodyWrapper = new HttpServletResponseBodyWrapper(response);
        AuditLogDO operation = AuditLogDO.builder()
                .method(request.getMethod())
                .path(request.getRequestURI())
                .requestBody(requestBodyWrapper.getBody())
                .responseBody(responseBodyWrapper.getBody())
                .build();
        User user = (User) request.getAttribute("user");
        if (user != null) {
            operation.setUsername(user.getUsername());
        }
        operation = repository.save(operation);
        request.setAttribute("AuditId", operation.getId());
        return super.preHandle(requestBodyWrapper, response, handler);
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String auditId = (String) request.getAttribute("AuditId");
        Optional<AuditLogDO> optional = repository.findById(auditId);
        if (optional.isPresent()) {
            AuditLogDO operation = optional.get();
            operation.setStatus(response.getStatus());
            repository.save(operation);
        }
        super.afterCompletion(request, response, handler, ex);
    }

}
