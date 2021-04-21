package com.testcy.servlet;

import com.google.gson.Gson;
import com.testcy.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjaxRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Ajax请求过来了！");
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }

    protected void jqueryAjaxRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jqueryAjaxRequest请求过来了！");
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }
    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jqueryGet请求过来了！");
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }
    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jqueryPost请求过来了！");
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }
    protected void jqueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jqueryGetJson请求过来了！");
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }

    protected void jquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jquerySerialize请求过来了！");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        Person person = new Person(1, "Curry");
        Gson gson = new Gson();
        String personJsonStr = gson.toJson(person);
        resp.getWriter().write(personJsonStr);

    }
}
