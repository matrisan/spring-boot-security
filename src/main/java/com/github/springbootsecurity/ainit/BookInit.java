package com.github.springbootsecurity.ainit;

import com.github.springbootsecurity.pojo.UserBookDO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 创建时间为 下午7:50 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class BookInit {

    @Resource(name = "userBook")
    private ConcurrentHashMap<String, UserBookDO> map;

    @PostConstruct
    public void init() {
        map.put("java", UserBookDO.builder().id(1).name("java").username("user").build());
        map.put("python", UserBookDO.builder().id(2).name("python").username("admin").build());
        map.put("c", UserBookDO.builder().id(3).name("c").username("root").build());
    }

}
