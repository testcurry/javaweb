package com.testcy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDispather2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看柜台一的材料  请求参数
        String username = req.getParameter("username");
        System.out.println("在柜台2中查看拆料。。。"+username);
        //查看柜台一的章
        Object value = req.getAttribute("key");
        System.out.println("柜台1是否有章："+value);

        //处理自己的业务
        System.out.println("servlet2处理自己的业务");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
