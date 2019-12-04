//package com.github.springbootsecurity.service.application.impl;
//
//import com.github.springbootsecurity.pojo.doo.SystemUserDO;
//import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
//import com.github.springbootsecurity.service.application.ISystemUserService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * <p>
// * 创建时间为 上午11:45 2019/10/18
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//@Service
//public class SystemUserServiceImpl implements ISystemUserService {
//
//    @Resource
//    private ISystemUserJpaRepository userJpaRepository;
//
//    @Override
//    public Page<SystemUserDO> findAllUsers(Pageable pageable) {
//        return userJpaRepository.findAll(pageable);
//    }
//
//}
