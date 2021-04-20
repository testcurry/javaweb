package com.testcy.test;

import com.testcy.dao.OrderDao;
import com.testcy.dao.impl.OrderDaoImpl;
import com.testcy.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        int count = orderDao.saveOrder(new Order("1", new Date(), new BigDecimal("99.99"), 0, 1));
        System.out.println("插入"+count+"记录！");
    }
}