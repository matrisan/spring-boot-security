//package com.github.springbootsecurity.audit.interceptor;
//
//import com.github.springbootsecurity.audit.pojo.AuditLogDO;
//import com.github.springbootsecurity.audit.repository.AuditLogRepository;
//import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//import org.springframework.web.util.WebUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.UnsupportedEncodingException;
//import java.util.Optional;
//
///**
// * <p>
// * 创建时间为 下午8:57 2019/12/18
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@Component
//public class AuditLogInterceptor extends HandlerInterceptorAdapter {
//
//    @Resource
//    private AuditLogRepository repository;
//
//    @Override
//    public boolean preHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        ContentCachingRequestWrapper wrapperRequest = new ContentCachingRequestWrapper(request);
//        super.preHandle(wrapperRequest, response, handler);
//        AuditLogDO operation = AuditLogDO.builder()
//                .method(request.getMethod())
//                .path(request.getRequestURI())
//                .requestBody(StringUtils.deleteWhitespace(getRequestBody(wrapperRequest)))
//                .build();
//        operation = repository.save(operation);
//        request.setAttribute("audit_id", operation.getId());
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(response);
//        super.afterCompletion(request, response, handler, ex);
//        String auditId = (String) request.getAttribute("audit_id");
//        Optional<AuditLogDO> optional = repository.findById(auditId);
//        if (optional.isPresent()) {
//            String responseBody = getResponseBody(wrapperResponse);
//            AuditLogDO auditLogDO = optional.get();
//            auditLogDO.setResponseBody(responseBody);
//            auditLogDO.setStatus(response.getStatus());
//            repository.save(auditLogDO);
//            System.out.println(auditLogDO.toString());
//        }
//        wrapperResponse.copyBodyToResponse();
//    }
//
//
//
//    /**
//     * 打印请求参数
//     *
//     * @param request
//     */
//    @NotNull
//    private String getRequestBody(ContentCachingRequestWrapper request) {
//        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
//
//        if (wrapper != null) {
//            byte[] buf = wrapper.getContentAsByteArray();
//            if (buf.length > 0) {
//                String payload;
//                try {
//                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
//                } catch (UnsupportedEncodingException e) {
//                    payload = "[unknown]";
//                }
//                return payload.replaceAll("\\n", "");
//            }
//        }
//        return "";
//    }
//
//    /**
//     * 打印请求参数
//     *
//     * @param response
//     */
//    private String getResponseBody(ContentCachingResponseWrapper response) {
//        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
//        if (wrapper != null) {
//            byte[] buf = wrapper.getContentAsByteArray();
//            if (buf.length > 0) {
//                String payload;
//                try {
//                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
//                } catch (UnsupportedEncodingException e) {
//                    payload = "[unknown]";
//                }
//                return payload;
//            }
//        }
//        return "";
//    }
//
//
//}
