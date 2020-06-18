package com.github.springbootsecurity.security.retrieve.impl;

import com.github.springbootsecurity.security.pojo.dto.RetrievePasswordDTO;
import com.github.springbootsecurity.security.pojo.vo.RetrieveMessageVO;
import com.github.springbootsecurity.security.retrieve.IRetrievePassword;
import org.springframework.stereotype.Component;

/**
 * @author 石少东
 * @date 2020-06-18 15:15
 * @since 1.0
 */

@Component("mobile")
public class RetrievePasswordMobileImpl implements IRetrievePassword {

    @Override
    public RetrieveMessageVO retrieve(RetrievePasswordDTO password) {
        return null;
    }
}
