package com.testcy.servlet;

import com.testcy.pojo.Cart;
import com.testcy.pojo.User;
import com.testcy.service.OrderService;
import com.testcy.service.impl.OrderServiceImpl;
import com.testcy.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{

    private OrderService orderService=new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OrderServlet当前线程名："+Thread.currentThread().getName());
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("loginUser");

        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer id = loginUser.getId();

        String orderId = orderService.createOrder(cart, id);
        //使用TransactionFilter过滤器统一管理事务
     /*   String orderId = null;
        try {
            orderId = orderService.createOrder(cart, id);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
        }*/
//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        //请求转发会造成表单重复提交，此处改成重定向
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
        System.out.println(orderId);


    }
}
