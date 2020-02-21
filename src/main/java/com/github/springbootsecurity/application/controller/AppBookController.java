package com.github.springbootsecurity.application.controller;

import com.github.springbootsecurity.application.pojo.AppBookDO;
import com.github.springbootsecurity.application.repository.AppBookRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:00 2020/2/20
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@PreAuthorize("isAuthenticated()")
public class AppBookController {

    @Resource
    private AppBookRepository repository;

    @GetMapping("books")
    public List<AppBookDO> findAll() {
        return repository.findAll();
    }

    @PostMapping("book")
    public AppBookDO save(@RequestBody AppBookDO appBook) {
        return repository.save(appBook);
    }

}
