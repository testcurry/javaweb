package com.testcy.servlet;

import com.testcy.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建session,创建和获取session是同一个方法
        HttpSession session = req.getSession();
        boolean isNew = session.isNew();
        String sessionId = session.getId();
        resp.getWriter().write("得到的sessionId为" + sessionId + "</br>");
        resp.getWriter().write("是否为新创建的？" + isNew);
    }

    /**
     * 往session中保存数据
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经向session域中保存数据!");

    }

    /**
     * 获取session域中保存的数据
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session域中获取的数据："+attribute);

    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session默认的生命时长
        HttpSession session = req.getSession();
        int maxInactiveInterval = session.getMaxInactiveInterval();
        resp.getWriter().write("session默认的生命时长为"+maxInactiveInterval+"秒");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().write("session已经被销毁！");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        //设置存活时间，以秒为单位
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie" + cookie);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);
        resp.getWriter().write("已经设置session的超时时间为3秒钟！");
    }
}
