package com.testcy.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前置filter2");
        System.out.println(Thread.currentThread().getName()+"flter2");
        System.out.println(servletRequest.getAttribute("key1"));
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("后置filter2");
        System.out.println(Thread.currentThread().getName()+"flter2");
    }

    @Override
    public void destroy() {

    }

}
