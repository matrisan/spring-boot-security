package com.github.springbootsecurity.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 创建时间为 下午4:02 2020/2/14
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class TestPasswordEncoder {

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        String encoderPassword1 = passwordEncoder1().encode("123456");
        String encoderPassword2 = passwordEncoder2().encode("123456");

        System.out.println("encoderPassword1:" + encoderPassword1);
        System.out.println("encoderPassword2:" + encoderPassword2);


        System.out.println("相等:" + passwordEncoder.matches("123456", encoderPassword1));
        System.out.println("相等:" + passwordEncoder.matches("123456", encoderPassword2));
    }

    public PasswordEncoder passwordEncoder1() {
        String encodingId = "pbkdf2";
        Map<String, PasswordEncoder> encoders = new HashMap<>(8);
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

    public PasswordEncoder passwordEncoder2() {
        String encodingId = "scrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>(8);
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

}
