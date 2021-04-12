package com.testcy.controller;

import com.testcy.pojo.User;
import com.testcy.service.UserService;
import com.testcy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确 先写死abcde检查
        if (code.equalsIgnoreCase("abcde")) {
            //检查用户名是否可用
            if (userService.existsUser(username)) {
                System.out.println("用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                System.out.println("用户名可用！");
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                System.out.println("用户" + username + "保存数据库成功！");
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            //如果验证码错误，跳回注册页面，请求转发
            System.out.println("验证码" + code + ",错误！");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
