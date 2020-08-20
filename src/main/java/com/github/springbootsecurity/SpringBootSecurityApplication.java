package com.github.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 *
 * maxInactiveIntervalInSeconds:
 * 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
 *
 * @author shao
 */
@EnableRedisHttpSession
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

}
