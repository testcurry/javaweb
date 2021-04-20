package com.testcy.test;

import com.testcy.dao.OrderItemDao;
import com.testcy.dao.impl.OrderItemDaoImpl;
import com.testcy.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        int count = orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到精通", 10, new BigDecimal("99.99"), new BigDecimal("9999"), "1"));
        int count1 = orderItemDao.saveOrderItem(new OrderItem(null, "javaScript从入门到精通", 10, new BigDecimal("99.99"), new BigDecimal("9999"), "1"));
        int count2 = orderItemDao.saveOrderItem(new OrderItem(null, "python从入门到精通", 10, new BigDecimal("99.99"), new BigDecimal("9999"), "1"));
        System.out.println("插入"+(count+count2+count1)+"条记录！");

    }
}