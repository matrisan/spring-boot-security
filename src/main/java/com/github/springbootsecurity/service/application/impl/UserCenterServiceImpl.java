package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.service.application.IUserCenterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 下午1:31 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class UserCenterServiceImpl implements IUserCenterService {

    @Override
    public Page<UserBookDO> findAllBooksOwned(Pageable pageable) {
        return null;
    }

}
