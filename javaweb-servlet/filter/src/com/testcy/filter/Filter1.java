package com.testcy.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前置filter1");
        System.out.println(Thread.currentThread().getName()+"flter1");
        servletRequest.setAttribute("key1","value1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("后置filter1");
        System.out.println(Thread.currentThread().getName()+"flter1");
    }

    @Override
    public void destroy() {

    }

}
