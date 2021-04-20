package com.testcy.test;

import com.testcy.pojo.Cart;
import com.testcy.pojo.CartItem;
import com.testcy.service.OrderService;
import com.testcy.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(88), new BigDecimal(88)));
        OrderService orderService=new OrderServiceImpl();
        String orderId = orderService.createOrder(cart, 1);
        System.out.println(orderId);
    }
}