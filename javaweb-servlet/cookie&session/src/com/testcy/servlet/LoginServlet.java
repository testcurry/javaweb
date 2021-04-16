package com.testcy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 7);
            resp.addCookie(cookie);
            System.out.println("登录成功！");
        }else {
            System.out.println("登录失败！");
        }
    }
}
