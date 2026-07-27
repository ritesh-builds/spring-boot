package com.example.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {
        String userRole = request.getHeader("x-user-role");

        if(userRole == null || !userRole.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\n" +
                    "    \"message\": \"You are not authorized to perform.\"\n" +
                    "}");
            return false;
        }

        return true;
    }
}
