package com.testcy.servlet;

import com.testcy.pojo.Book;
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

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Book book = WebUtils.copyParamsToBean(parameterMap, new Book());
        bookService.addBook(book);
        //请求转发有bug，添加图书完成后，由于请求转发是一次请求，此时刷新当前页面会再次发起上一次请求，此处使用请求重定向
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种方式使用beanUtils工具类获取id
//        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
//        bookService.deleteBookById(book.getId());
        //第二种方式直接获取id
        Integer id = Integer.parseInt(req.getParameter(("id")));
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void getBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改图书信息时，将修改的信息保存到request域中，给book_edit.jsp显示
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBookById(id);
        req.setAttribute("bookEdit",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void queryBookById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryAllBooks();
        req.setAttribute("books", books);
        //请求转发到/pages/manager/manager.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/manager/book_manager.jsp");
        requestDispatcher.forward(req, resp);

    }

}
