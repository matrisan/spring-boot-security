package com.github.springbootsecurity.back;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * <p>
 * 创建时间为 下午7:05 2019/10/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


public class BackLoginAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 2551197203205567977L;

    private final Object principal;

    /**
     * 第一次调用使用使用这个组装凭证
     *
     * @param mobile 手机号码
     */
    public BackLoginAuthenticationToken(String mobile) {
        super(null);
        this.principal = mobile;
        setAuthenticated(false);
    }

    /**
     * 这个构造方法只在用户身份被验证之后使用(一般只在AuthenticationProvider中验证通过后使用),
     *
     * @param mobile      手机号码
     * @param authorities 角色权限
     */
    public BackLoginAuthenticationToken(Object mobile, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = mobile;
        super.setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
