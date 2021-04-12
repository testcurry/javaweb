package com.testcy.servlet;

import javax.servlet.*;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1_构造器方法。。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        System.out.println("2_init方法。。。");
        //获取servlet程序的别名：
        System.out.println("helloServlet的别名是："+servletConfig.getServletName());
        //获取servlet程序的初始化参数init-param
        System.out.println("初始化参数username的值为："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值为："+servletConfig.getInitParameter("url"));
        //获取servletContext对象
        System.out.println("servletContex对象为："+servletConfig.getServletContext());

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
        if ("GET".equalsIgnoreCase(method)) {
            doGet();
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost();
        }
    }

    private void doPost() {
        System.out.println("POST请求！");
        System.out.println("POST请求！");

    }

    private void doGet() {
        System.out.println("GET请求！");
        System.out.println("GET请求！");
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
