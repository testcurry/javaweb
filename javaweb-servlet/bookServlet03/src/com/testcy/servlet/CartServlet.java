package com.testcy.servlet;

import com.google.gson.Gson;
import com.testcy.pojo.Book;
import com.testcy.pojo.Cart;
import com.testcy.pojo.CartItem;
import com.testcy.service.BookService;
import com.testcy.service.impl.BookServiceImpl;
import com.testcy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();
//    private Cart cart=new Cart();


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.paseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());
        HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("lastName",cartItem.getName());
        cartMap.put("totalCount",cart.getTotalCount());
        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cartMap);
        resp.getWriter().write(cartJsonStr);
    }

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("加入购物车成功！");
//        System.out.println("商品id="+req.getParameter("id"));
//        System.out.println(req.getHeader("Referer"));
        int id = WebUtils.paseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());
//        System.out.println(cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }


    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.paseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateItemCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.paseInt(req.getParameter("id"),0);
        int count = WebUtils.paseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateItemCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
