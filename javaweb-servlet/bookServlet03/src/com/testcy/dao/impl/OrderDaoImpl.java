package com.testcy.dao.impl;

import com.testcy.dao.OrderDao;
import com.testcy.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderDaoImpl当前线程名："+Thread.currentThread().getName());
        String sql="insert into t_order (`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        int count = update(sql,order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return count;
    }
}
