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
        RiskDTO risk = assembleRiskData(request, getData(data));
        // TODO
        // 请求远程风控接口，这个地方要设置熔断，设置重试次数，设置熔断默认风险
        // 下面为模拟
        processRiskResult(RiskResultBO.builder().score(90).build());
    }

    /**
     * 组装请求风控接口的数据，数据来源 HttpServletRequest 和用户请求的 body。
     *
     * @param request HttpServletRequest
     * @param data    用户请求的Body数据
     * @return 请求风控接口的数据
     */
    public abstract RiskDTO assembleRiskData(HttpServletRequest request, T data);

    /**
     * 处理风控返回的结果
     *
     * @param result 请求风控返回的结果
     */
    public abstract void processRiskResult(RiskResultBO result);
}
