package com.och.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.och.common.base.ResResult;
import com.och.common.constant.HttpStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author danmo
 * @date 2024-02-22 10:06
 **/
@Component
public class OchAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONObject.toJSONString(ResResult.error(HttpStatus.UNAUTHORIZED,"未授权,请登录后重试")));
        response.getWriter().flush();
    }
}
