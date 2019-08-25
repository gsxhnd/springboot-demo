package com.ldblockchain.sls.Interceptor;

import com.ldblockchain.sls.util.JWTUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jimo
 * @func 拦截token并验证，不通过则抛出异常
 * @date 2018/8/24 22:38
 */
public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new ServletException("USER_INVALID_TOKEN_HEAD");
        }
        // 取得token
        String token = authorization.substring(7);
        try {
            JWTUtil.checkToken(token);
            return true;
        } catch (Exception e) {
            throw new ServletException("USER_INVALID_TOKEN");
        }
    }
}
