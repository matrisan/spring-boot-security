package com.github.springbootsecurity.risk.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootsecurity.risk.pojo.RiskDTO;
import com.github.springbootsecurity.risk.pojo.RiskResultBO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 创建时间为 下午1:40 2019/12/19
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public abstract class BaseRiskService<T> {

    @Resource
    private ObjectMapper objectMapper;

    private Class<T> aClass;

    public BaseRiskService(Class<T> aClass) {
        this.aClass = aClass;
    }

    public T getData(String data) {
        return JSON.parseObject(data, aClass);
    }

    public void get(HttpServletRequest request, String data) {
        RiskDTO risk = getRisk(request, getData(data));
        // TODO
        processRiskResult(RiskResultBO.builder().score(90).build());
    }

    public abstract RiskDTO getRisk(HttpServletRequest request, T data);

    public abstract void processRiskResult(RiskResultBO result);

}
