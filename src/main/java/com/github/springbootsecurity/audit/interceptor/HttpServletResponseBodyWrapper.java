package com.github.springbootsecurity.audit.interceptor;

import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 创建时间为 下午3:05 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class HttpServletResponseBodyWrapper extends HttpServletResponseWrapper {

    private HttpServletResponse response;

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public HttpServletResponseBodyWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    public String getBody() {
        return new String(byteArrayOutputStream.toByteArray());
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return getServletOutputStream(byteArrayOutputStream, response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(this.getOutputStream(), StandardCharsets.UTF_8));
    }

    @NotNull
    private ServletOutputStream getServletOutputStream(ByteArrayOutputStream bytes, HttpServletResponse response) {
        return new ServletOutputStream() {

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setWriteListener(WriteListener listener) {

            }

            @Override
            public void write(int b) throws IOException {
                bytes.write(b);
            }

            @Override
            public void flush() throws IOException {
                if (!response.isCommitted()) {
                    byte[] body = bytes.toByteArray();
                    ServletOutputStream outputStream = response.getOutputStream();
                    outputStream.write(body);
                    outputStream.flush();
                }
            }
        };

    }
}
