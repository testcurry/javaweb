package com.testcy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println(context.getAttribute("key1"));
        context.setAttribute("key1","value1");
        System.out.println(context.getAttribute("key1"));
        System.out.println(context.getAttribute("key1"));
        System.out.println(context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
