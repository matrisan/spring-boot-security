package com.github.springbootsecurity.security.controller.common.impl;

import com.github.springbootsecurity.security.controller.common.ICommonUserController;
import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.validated.Save;
import com.github.springbootsecurity.security.validated.Update;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午8:01 2020/2/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/system/common")
public class CommonUserControllerImpl implements ICommonUserController {

    @Resource
    private ISystemGroupRepository groupRepository;

    @Resource
    private ISystemUserRepository userRepository;

    @GetMapping("/user")
    @Override
    public ResultDTO<Page<SystemUserDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                                 @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        Set<String> username = systemUserDO.getSystemGroup().getSystemUsers().stream()
                .map(SystemUserDO::getUsername).collect(Collectors.toSet());
        return ResultDTO.success(userRepository.findAllByUsernameIn(username, pageable));
    }

    @PreAuthorize("@authorizeUserService.hasUserPermission(authentication,#userId)")
    @GetMapping("/user/{userId}")
    @Override
    public ResultDTO<SystemUserDO> findById(@PathVariable Long userId) {
        return ResultDTO.success(userRepository.findById(userId).orElse(null));
    }

    @PostMapping("/user")
    @Override
    public ResultDTO<SystemUserDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemUserDO systemUser,
                                        @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        SystemGroupDO systemGroup = systemUserDO.getSystemGroup();
        systemUser.setSystemGroup(systemGroup);
        return ResultDTO.success(userRepository.save(systemUser));
    }


    @PutMapping("/user")
    @Override
    public ResultDTO<SystemUserDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemUserDO systemUser,
                                          @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        SystemGroupDO systemGroup = systemUserDO.getSystemGroup();
        systemUser.setSystemGroup(systemGroup);
        return ResultDTO.success(userRepository.save(systemUser));
    }


    @PreAuthorize("@authorizeUserService.hasUserPermission(authentication,#userId)")
    @DeleteMapping("/user/{userId}")
    @Override
    public ResultDTO<Void> deleteById(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return ResultDTO.success();
    }

}
