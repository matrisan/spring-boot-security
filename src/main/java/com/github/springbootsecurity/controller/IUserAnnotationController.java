package com.github.springbootsecurity.controller;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:34 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserAnnotationController {

    List<Integer> preFilter(List<Integer> nums);

    List<Integer> postFilter(List<Integer> nums);

    List<Integer> prePostFilter(List<Integer> nums);

    Integer preAuthorize(Integer num);

    Integer postAuthorize(Integer num);

}
