package com.github.springbootsecurity.security.service.common;

import com.github.springbootsecurity.security.pojo.dto.RetrievePasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.vo.RetrieveMessageVO;

/**
 * @author 石少东
 * @date 2020-06-16 17:53
 */

public interface IUserPublicService {

    Void register(UserRegisterDTO register);

    RetrieveMessageVO retrievePassword(String type, RetrievePasswordDTO retrieve);
}
