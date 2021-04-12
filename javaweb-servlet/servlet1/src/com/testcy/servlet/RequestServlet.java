package com.testcy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求资源路径
        String requestURI = req.getRequestURI();
        System.out.println("URI："+requestURI);
        //获取请求的统一资源定位符
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("URL："+requestURL);
        //获取请求的客户端的地址
        String remoteHost = req.getRemoteHost();
        System.out.println("客户端的地址:"+remoteHost);

        //获取请求头
        String agent = req.getHeader("user-agent");
        System.out.println("浏览器版本："+agent);
        //获取请求方式
        String method = req.getMethod();
        System.out.println("请求方式"+method);
    }
}
