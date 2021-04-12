package com.testcy.controller;

import com.testcy.pojo.User;
import com.testcy.service.UserService;
import com.testcy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //根据用户名和密码查询数据库比对
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser==null){
            System.out.println("用户名或密码错误！");
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else {
            System.out.println("登录成功！");
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
