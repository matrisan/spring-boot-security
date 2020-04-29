package com.github.springbootsecurity.security.back;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午7:20 2019/10/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
public class BackLoginAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        BackLoginAuthenticationToken backLoginAuthenticationToken = (BackLoginAuthenticationToken) authentication;
        String username = (String) backLoginAuthenticationToken.getPrincipal();
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (user == null) {
            throw new InternalAuthenticationServiceException("无法获取用户信息");
        }
        BackLoginAuthenticationToken authenticationResult = new BackLoginAuthenticationToken(user, user.getAuthorities());
        authenticationResult.setDetails(backLoginAuthenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return BackLoginAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
