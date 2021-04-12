package com.testcy.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("context-param的username的参数值为："+username);
        System.out.println("context-param的password的参数值为："+password);
        //获取当前工程路径
        System.out.println("当前工程的路径为："+context.getContextPath());
        //获取工程部署后再服务器上的绝对路径
        System.out.println("部署在服务器上的绝对路径为"+context.getRealPath("/"));
        //获取curry.jpg部署在服务器上的绝对路径
        System.out.println("curry.jpg部署在服务器上的绝对路径"+context.getRealPath("/image"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
