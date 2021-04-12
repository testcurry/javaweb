package com.testcy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key","value1");
        System.out.println("ResponseServlet1曾到此一游！");
//        resp.setStatus(302);
//        resp.setHeader("location","http://localhost:8080/servlet/responseServlet2");
        //无法访问，因为请求重定向第二次请求还是浏览器发的，WEB-INF目录是受保护的，浏览器不能直接访问该目录的资源
//        resp.setHeader("location","http://localhost:8080/servlet/WEB-INF/form.html");
        //可以访问工程以外的路径,与请求重定向不同，请求重定向不能访问工程以外的资源
//        resp.setHeader("location","http://www.baidu.com");


        //请求重定向的第二种实现方式,一行代码搞定
        resp.sendRedirect("http://localhost:8080/servlet/responseServlet2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
