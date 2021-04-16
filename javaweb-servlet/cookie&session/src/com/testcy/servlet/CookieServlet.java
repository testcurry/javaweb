package com.testcy.servlet;

import com.testcy.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie，可以创建多个cookie
        Cookie cookie = new Cookie("key1", "value1");
        //通知客户端保存cookie
        resp.addCookie(cookie);
        Cookie cookie1 = new Cookie("key2", "value2");
        //通知客户端保存cookie
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功！");

    }

    /**
     * 服务器获取cookie，浏览器发起请求时，如果本地存在cookie则通过请求头cookie携带发给服务器，
     * 服务器只需要通过request对象获取即可
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //客户端获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie" + "【" + cookie.getName() + "】" + "=【" + cookie.getValue() + "】" + "</br>");
        }

       /* Cookie iWantCookie=null;
        for (Cookie cookie : cookies) {
            if ("key1".equals(cookie.getName())){
                iWantCookie=cookie;
                break;
            }
        }*/
        Cookie iWantCookie = CookieUtils.findCookieByCookieName("key1", cookies);
        resp.getWriter().write("想要的cookie：" + iWantCookie);

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种方式，通过服务器新生成一个同名cookie，cookie的name已经存在于客户端，此时会修改该cookie的值
        Cookie cookie = new Cookie("key1", "newValue");
        resp.addCookie(cookie);

        //第二种方式
        Cookie[] cookies = req.getCookies();
        Cookie cookieNew = CookieUtils.findCookieByCookieName("key2", cookies);
        cookieNew.setValue("newValue");
        resp.addCookie(cookieNew);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("default", "default");
        cookie.setMaxAge(-1);//-1表示session级别，关掉浏览器cookie信息会删除
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookieByCookieName("key1", req.getCookies());
        //立即刪除cookie
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.getWriter().write(cookie+"被立即删除!");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        //设置存活时间，以秒为单位
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie"+cookie);
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path", "path");
//        req.getContextPath()获取当前路径
        System.out.println(req.getContextPath());
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了带有path路径的cookie");
    }
}
