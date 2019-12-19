package com.github.springbootsecurity.risk.service.impl;

import com.github.springbootsecurity.risk.pojo.DataDO;
import com.github.springbootsecurity.risk.pojo.RiskDTO;
import com.github.springbootsecurity.risk.pojo.RiskResultBO;
import com.github.springbootsecurity.risk.service.BaseRiskService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 创建时间为 下午1:42 2019/12/19
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class RiskServiceImpl extends BaseRiskService<DataDO> {

    public RiskServiceImpl() {
        super(DataDO.class);
    }

    @Override
    public RiskDTO getRisk(@NotNull HttpServletRequest request, @NotNull DataDO data) {
        return RiskDTO.builder()
                .url(request.getRequestURI())
                .data(data.getData())
                .build();
    }

    @Override
    public void processRiskResult(@NotNull RiskResultBO result) {
        System.out.println(result.toString());
    }
}
