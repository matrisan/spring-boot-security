package com.github.springbootsecurity.controller.impl;

import com.github.springbootsecurity.controller.IUserBookController;
import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.service.IUserBookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 上午10:56 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class UserBookControllerImpl implements IUserBookController {

    @Resource
    private IUserBookService service;

    @GetMapping("/book/{bookName}")
    @PreAuthorize("hasRole('ROLE_USER') and @userAuthorizeServiceImpl.hasPermission(authentication,#bookName)")
    @Override
    public UserBookDO getBookByBookName(@PathVariable String bookName) {
        return service.findBookByBookName(bookName);
    }

    @GetMapping("/books")
    @PreAuthorize("hasRole('ROLE_ROOT')")
    @Override
    public List<UserBookDO> getAllBooks() {
        return service.findAllBooks();
    }

}
