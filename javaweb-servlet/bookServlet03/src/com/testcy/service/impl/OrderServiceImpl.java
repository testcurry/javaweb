package com.testcy.service.impl;

import com.testcy.dao.BookDao;
import com.testcy.dao.OrderDao;
import com.testcy.dao.OrderItemDao;
import com.testcy.dao.impl.BookDaoImpl;
import com.testcy.dao.impl.OrderDaoImpl;
import com.testcy.dao.impl.OrderItemDaoImpl;
import com.testcy.pojo.*;
import com.testcy.service.OrderService;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        System.out.println("OrderServiceImpl当前线程名："+Thread.currentThread().getName());
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        //模拟异常
//        int i=10/0;

        Map<Integer, CartItem> items = cart.getItems();
        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
        Iterator<Map.Entry<Integer, CartItem>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next().getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
//            保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
