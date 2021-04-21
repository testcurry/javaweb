package com.testcy.dao.impl;

import com.testcy.dao.OrderItemDao;
import com.testcy.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl当前线程名："+Thread.currentThread().getName());
        String sql="insert into t_order_item(`name`,`count`,`price`,`totalPrice`,`order_id`)values(?,?,?,?,?)";
        int count = update(sql,orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return count;
    }
}
