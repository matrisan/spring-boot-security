package com.github.springbootsecurity.controller.system;

import com.github.springbootsecurity.pojo.doo.SmsCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

import static com.github.springbootsecurity.security.SecurityConstant.SESSION_KEY_CODE_SMS;

/**
 * <p>
 * 创建时间为 上午11:05 2019/11/29
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@RestController
public class BackLoginController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 1.生成随机码;
     * 2.发送短信
     * 3.存入Session;
     *
     * @param request
     */
    @PreAuthorize("permitAll()")
    @GetMapping("/code/sms")
    public void getSmsCode(@NotNull HttpServletRequest request) throws ServletRequestBindingException {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        SmsCode smsCode = generate(servletWebRequest);
        sessionStrategy.setAttribute(servletWebRequest, SESSION_KEY_CODE_SMS, smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        send(mobile, smsCode.getCode());
    }


    @NotNull
    private SmsCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(6);
        return new SmsCode(code, 90);
    }

    private void send(String mobile, String code) {
        log.info("向手机发动验证码:{}-{}", mobile, code);
    }


}
