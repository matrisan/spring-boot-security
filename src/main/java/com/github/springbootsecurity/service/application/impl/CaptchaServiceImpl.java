package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.common.CaptchaUtil;
import com.github.springbootsecurity.service.application.ICaptchaService;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 创建时间为 下午1:02 2019/10/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CaptchaServiceImpl implements ICaptchaService {

    @Resource
    private CaptchaUtil captchaUtil;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    @SneakyThrows(IOException.class)
    public void getCaptcha(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        // 获取到 session
        HttpSession session = request.getSession();
        // 取到 sessionid
        String id = session.getId();
        System.out.println("---------------" + id);
        // 利用图片工具生成图片
        CaptchaUtil.Captcha captcha = captchaUtil.createImage();
        // 将验证码存入Session
        session.setAttribute("SESSION_VERIFY_CODE_" + id, captcha.getCaptcha());
        // 打印验证码
        System.out.println(captcha.getCaptcha());
        // 设置redis值的序列化方式
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 在redis中保存一个验证码最多尝试次数
        redisTemplate.opsForValue().set(("VERIFY_CODE_" + id), "3", 1, TimeUnit.MINUTES);
        // 将图片输出给浏览器
        BufferedImage image = captcha.getImage();
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }


    @Override
    public String checkCode(String code, @NotNull HttpServletRequest request) {
        HttpSession session = request.getSession();
        String id = session.getId();
        // 将redis中的尝试次数减一
        String verifyCodeKey = "VERIFY_CODE_" + id;
        Long num = redisTemplate.opsForValue().decrement(verifyCodeKey);
        // 如果次数次数小于0 说明验证码已经失效
        assert num != null;
        if (0 > num.intValue()) {
            return "验证码失效!";
        }
        // 将session中的取出对应session id生成的验证码
        String serverCode = (String) session.getAttribute("SESSION_VERIFY_CODE_" + id);
        // 校验验证码
        if (null == serverCode || null == code || !serverCode.toUpperCase().equals(code.toUpperCase())) {
            return "验证码错误!";
        }
        // 验证通过之后手动将验证码失效
//        redisTemplate.delete(verifyCodeKey);
        // 这里做具体业务相关
        return "验证码正确!";
    }
}
