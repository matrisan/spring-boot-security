package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IUserCenterController;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.service.application.IUserCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午12:45 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
@RequestMapping("/user/center")
@PreAuthorize("isAuthenticated()")
public class UserCenterControllerImpl implements IUserCenterController {

    @Resource
    private IUserCenterService service;

    @Override
    @GetMapping("/auth")
    public ReturnDTO<Authentication> getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        log.info("getAuthentication:{}", JSON.toJSONString(authentication));
        return ReturnDTO.<Authentication>builder().status(0).data(authentication).build();
    }

    @Override
    @GetMapping("/info")
    public ReturnDTO<SystemUserDO> getUserDetails(@AuthenticationPrincipal SystemUserDO systemUserDO) {
//        log.info("getUserDetails:{}", JSON.toJSONString(userDetails));
        return ReturnDTO.<SystemUserDO>builder().status(0).data(systemUserDO).build();
    }

    @Override
    @GetMapping("/books")
    public ReturnDTO<Page<UserBookDO>> findAllBooksOwned(@PageableDefault(size = 5, page = 0, sort = "id", direction = Sort.Direction.ASC)
                                                                 Pageable pageable) {
        return ReturnDTO.<Page<UserBookDO>>builder().status(0).data(service.findAllBooksOwned(pageable)).build();
    }

    @Override
    @GetMapping("/book/{id}")
    @PreAuthorize("hasRole('ROLE_USER') and @userAuthorizeServiceImpl.hasPermission(authentication, #userBookDO.bookId)")
    public ReturnDTO<UserBookDO> findByBookId(@PathVariable("id") UserBookDO userBookDO) {
        return ReturnDTO.<UserBookDO>builder().status(0).data(userBookDO).build();
    }

}
