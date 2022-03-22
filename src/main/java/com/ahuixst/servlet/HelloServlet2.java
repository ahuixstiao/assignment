package com.ahuixst.servlet;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/3/5 - 19:01
 **/
public class HelloServlet2 implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        String mysql = config.getInitParameter("jdbc");
        System.out.println(mysql);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            String name = httpServletRequest.getParameter("name");
            System.out.println(name);
            System.out.println(method);
        }else if("POST".equals(method)){
            String name = httpServletRequest.getParameter("name");
            System.out.println(name);
            System.out.println(method);
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
