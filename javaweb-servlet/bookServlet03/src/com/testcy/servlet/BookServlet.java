package com.testcy.servlet;

import com.testcy.pojo.Book;
import com.testcy.pojo.Page;
import com.testcy.service.BookService;
import com.testcy.service.impl.BookServiceImpl;
import com.testcy.utils.WebUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookService.page(pageNo,pageSize)方法,返回Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //保存到page对象的request域中
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page", page);
        //请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        pageNo+=1;
        Map<String, String[]> parameterMap = req.getParameterMap();
        Book book = WebUtils.copyParamsToBean(parameterMap, new Book());
        bookService.addBook(book);
        //请求转发有bug，添加图书完成后，由于请求转发是一次请求，此时刷新当前页面会再次发起上一次请求，此处使用请求重定向
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种方式使用beanUtils工具类获取id
//        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
//        bookService.deleteBookById(book.getId());
        //第二种方式直接获取id
        Integer id = Integer.parseInt(req.getParameter(("id")));
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改图书信息时，将修改的信息保存到request域中，给book_edit.jsp显示
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBookById(id);
        req.setAttribute("bookEdit", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryAllBooks();
        req.setAttribute("books", books);
        //请求转发到/pages/manager/manager.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_manager.jsp");
        requestDispatcher.forward(req, resp);

    }

}
