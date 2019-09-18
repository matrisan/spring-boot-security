package com.github.springbootsecurity.service.impl;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.pojo.UserRoleDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.repository.IUserBookRepository;
import com.github.springbootsecurity.repository.IUserInfoRepository;
import com.github.springbootsecurity.repository.IUserRoleRepository;
import com.github.springbootsecurity.service.IUserRootService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:17 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserRootServiceImpl implements IUserRootService {

    @Resource
    private IUserInfoRepository userInfoRepository;

    @Resource
    private IUserBookRepository userBookRepository;

    @Resource
    private IUserRoleRepository userRoleRepository;

    @Override
    public ReturnDTO<List<UserInfoDO>> findAllUsers() {
        return ReturnDTO.<List<UserInfoDO>>builder().data(userInfoRepository.findAll()).build();
    }

    @Override
    public ReturnDTO<List<UserRoleDO>> findAllRoles() {
        return ReturnDTO.<List<UserRoleDO>>builder().data(userRoleRepository.findAll()).build();
    }

    @Override
    public ReturnDTO<List<UserBookDO>> findAllBooks() {
        return ReturnDTO.<List<UserBookDO>>builder().data(userBookRepository.findAll()).build();
    }
}
