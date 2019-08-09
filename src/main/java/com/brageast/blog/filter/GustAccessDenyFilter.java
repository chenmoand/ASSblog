package com.brageast.blog.filter;

import com.brageast.blog.util.entity.ResultState;
import com.brageast.blog.util.entity.State;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GustAccessDenyFilter implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setStatus(403);
        httpServletResponse.getWriter().write(new ResultState(State.NODEFINED, "您无法访问这个API或者页面").toJsonString());
    }
}
