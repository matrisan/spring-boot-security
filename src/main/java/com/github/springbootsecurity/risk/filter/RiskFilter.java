package com.github.springbootsecurity.risk.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootsecurity.risk.repository.AuditLogRepository;
import com.github.springbootsecurity.risk.service.BaseRiskService;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

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

@Order(Integer.MIN_VALUE + 1)
@Component
public class RiskFilter extends OncePerRequestFilter {

    @Resource
    private BaseRiskService service;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        BodyReaderHttpServletRequestWrapper wrapperRequest = new BodyReaderHttpServletRequestWrapper(request);
        String body = wrapperRequest.getBody();
        service.get(request, body);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(body + "   " + authentication.toString());
        filterChain.doFilter(wrapperRequest, response);
    }
}
