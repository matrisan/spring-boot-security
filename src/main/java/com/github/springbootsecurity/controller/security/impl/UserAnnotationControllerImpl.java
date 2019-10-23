package com.github.springbootsecurity.controller.security.impl;

import com.github.springbootsecurity.controller.security.IUserAnnotationController;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午1:35 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/user")
@RestController
public class UserAnnotationControllerImpl implements IUserAnnotationController {

    @PostMapping("prefilter")
    @PreFilter("filterObject %2 == 0")
    @Override
    public List<Integer> preFilter(@RequestBody List<Integer> nums) {
        return nums;
    }

    @PostMapping("postfilter")
    @PostFilter("filterObject %2 == 0")
    @Override
    public List<Integer> postFilter(@RequestBody List<Integer> nums) {
        return Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
    }

    @PostMapping("prepost")
    @PreFilter("filterObject %2 == 0")
    @PostFilter("filterObject %4 == 0")
    @Override
    public List<Integer> prePostFilter(@RequestBody List<Integer> nums) {
        return nums;
    }

    @GetMapping("/preauthorize/{num}")
    @Override
    public Integer preAuthorize(@PathVariable Integer num) {
        return num;
    }

    @GetMapping("/postauthorize/{num}")
    @PostAuthorize("returnObject %2 == 0")
    @Override
    public Integer postAuthorize(@PathVariable Integer num) {
        return num;
    }
}
