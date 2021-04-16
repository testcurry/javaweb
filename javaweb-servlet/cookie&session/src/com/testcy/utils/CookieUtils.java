package com.testcy.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie findCookieByCookieName(String cookieName,Cookie[] cookies){
        if (cookieName!=null&&!"".equals(cookieName)&&cookies.length!=0&&cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
