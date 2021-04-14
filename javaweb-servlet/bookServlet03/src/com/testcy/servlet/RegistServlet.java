package com.testcy.servlet;

import com.testcy.pojo.User;
import com.testcy.service.UserService;
import com.testcy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends UserServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        req.setAttribute("username",username);
        req.setAttribute("email",email);
        //检查验证码是否正确 先写死abcde检查
        if (code.equalsIgnoreCase("abcde")) {
            //检查用户名是否可用
            if (userService.existsUser(username)) {
                //把回显信息保存到request域中
                req.setAttribute("msg","用户名已存在!");
                System.out.println("用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                System.out.println("用户名可用！");
                //调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                System.out.println("用户" + username + "保存数据库成功！");
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //如果验证码错误，跳回注册页面，请求转发
            //把回显信息保存到request域中
            req.setAttribute("msg","验证码错误！");
            System.out.println("验证码" + code + ",错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
