package com.testcy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1、AdminFilter构造器方法！");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2、init方法！");
        //获取filter的别名filter-name
        System.out.println("filter-name:"+filterConfig.getFilterName());
        //获取初始化参数
        System.out.println("初始化参数username："+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url："+filterConfig.getInitParameter("url"));
        //获取servletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter() 专门用于拦截请求，做权限检查，过滤响应
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3、doFilter方法执行了！");
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
        Object user = httpServletRequest.getSession().getAttribute("loginUser");
        if (user==null){
            httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
            return;
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
//            httpServletRequest.getRequestDispatcher("/admin/a.jsp").forward(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4、destroy()方法执行了！");
    }
}
