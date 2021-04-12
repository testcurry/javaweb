package com.testcy.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取字符流后，字节流就不能在使用，反之亦然  不能同时使用两个输出流
//        ServletOutputStream outputStream = resp.getOutputStream();
        System.out.println("设置服务器的字符集前："+resp.getCharacterEncoding());//ISO-8859-1
//        //设置服务器字符集为utf-8
//        resp.setCharacterEncoding("utf-8");
//        //设置响应头，浏览器也用utf-8字符集解析
//        resp.setHeader("Content-Type","text/html;charset=utf-8");

        //设置服务器和客户端到utf-8字符集，注意要在获取输出流之前设置
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        System.out.println("设置服务器的字符集后的字符集："+resp.getCharacterEncoding());//utf-8
//        writer.write("hello response!");
        writer.write("返回中文数据!");

    }
}
