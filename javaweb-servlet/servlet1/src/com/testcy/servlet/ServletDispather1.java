package com.testcy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDispather1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servlet1请求的参数
        String username = req.getParameter("username");
        System.out.println("在柜台1中查看拆料。。。"+username);
        //给材料盖一个章，并传递到servlet2查看
        req.setAttribute("key","柜台1的章。");
        //问路，柜台2该怎么走  请求转发
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servletDispather2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
        //不能访问工程以外的资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");
        //走向柜台2
        requestDispatcher.forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
