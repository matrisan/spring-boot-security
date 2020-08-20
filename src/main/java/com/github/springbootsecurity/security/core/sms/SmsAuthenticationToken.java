//package com.github.springbootsecurity.security.core.sms;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
///**
// * <p>
// * 创建时间为 下午7:05 2019/10/26
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//
//public class SmsAuthenticationToken extends AbstractAuthenticationToken {
//
//    private static final long serialVersionUID = 2551197203205567977L;
//
//    private final Object principal;
//
//    /**
//     * This constructor can be safely used by any code that wishes to create a
//     * <code>UsernamePasswordAuthenticationToken</code>, as the {@link #isAuthenticated()}
//     * will return <code>false</code>.
//     */
//    public SmsAuthenticationToken(String mobile) {
//        super(null);
//        this.principal = mobile;
//        setAuthenticated(false);
//    }
//
//    /**
//     * This constructor should only be used by <code>AuthenticationManager</code> or
//     * <code>AuthenticationProvider</code> implementations that are satisfied with
//     * producing a trusted (i.e. {@link #isAuthenticated()} = <code>true</code>)
//     * authentication token.
//     *
//     * @param mobile
//     * @param authorities
//     */
//    public SmsAuthenticationToken(Object mobile, Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//        this.principal = mobile;
//        super.setAuthenticated(true);
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return this.principal;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        if (isAuthenticated) {
//            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
//        }
//        super.setAuthenticated(false);
//    }
//
//    @Override
//    public void eraseCredentials() {
//        super.eraseCredentials();
//    }
//}
