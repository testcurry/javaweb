package com.testcy.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1_构造器方法。。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2_init方法。。。");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("3_hello servlet!");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet();
        }else if ("POST".equalsIgnoreCase(method)){
            doPost();
        }
    }

    private void doPost() {
        System.out.println("POST请求！");
        System.out.println("POST请求！");

    }

    private void doGet() {
        System.out.println("GET请求！");
        System.out.println("GETT请求！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4_destroy方法。。");
    }
}
