package com.testcy.servlet;

import com.testcy.pojo.Book;
import com.testcy.pojo.Page;
import com.testcy.service.BookService;
import com.testcy.service.impl.BookServiceImpl;
import com.testcy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{

    private BookService bookService=new BookServiceImpl();
    /**
     * 处理分页的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("请求转发到clientServlet");
        //获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page(pageNo,pageSize)方法,返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //保存到page对象的request域中
        req.setAttribute("page", page);
        //请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }


    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("请求转发到clientServlet");
        //获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.paseInt(req.getParameter("min"), 0);
        int max = WebUtils.paseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //调用bookService.page(pageNo,pageSize)方法,返回Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        //方式一，将最大价格和最小价格带入查询请求参数中
//        page.setUrl("client/bookServlet?action=pageByPrice&min="+req.getParameter("min")+"&max="+req.getParameter("max"));
        //方式二
        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        String urlParam = stringBuilder.toString();
        page.setUrl(urlParam);
        //保存到page对象的request域中
        req.setAttribute("page", page);
        //请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
