package com.github.springbootsecurity.audit.interceptor;


import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>
 * 创建时间为 下午3:04 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class HttpServletRequestBodyWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public HttpServletRequestBodyWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = IOUtils.toByteArray(request.getInputStream());
    }

    public String getBody() {
        return new String(body);
    }

    @Override
    public ServletInputStream getInputStream() {
        return getServletInputStream(new ByteArrayInputStream(body));
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    private ServletInputStream getServletInputStream(ByteArrayInputStream byteArrayIns) {
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteArrayIns.read();
            }
        };
    }

}
