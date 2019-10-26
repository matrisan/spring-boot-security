package com.github.springbootsecurity.filter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY;

/**
 * 如果前端传过来的密码是加密的,需要解密,
 * 可以在 UsernamePasswordAuthenticationFilter 之后,
 * 验证码 Filter 之前添加解密操作
 *
 * <p>
 * 创建时间为 上午12:51 2019/10/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
public class SecurityPasswordDecryptionFilter extends OncePerRequestFilter {

    @Override
    @SneakyThrows({ServletException.class, IOException.class})
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) {
        filterChain.doFilter(new SecurityHttpServletRequestWrapper(request), response);
    }

    private static class SecurityHttpServletRequestWrapper extends HttpServletRequestWrapper {

        SecurityHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (StringUtils.equalsIgnoreCase(SPRING_SECURITY_FORM_PASSWORD_KEY, name)) {
                // 如果前端传输过来的密码是加密的。可以在这里解密。
                return value;
            }
            return value;
        }
    }

}
