package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;

/**
 * @author 石少东
 * @date 2020-06-16 17:53
 */

public interface IUserPublicService {

    Void register(UserRegisterDTO register);

}
