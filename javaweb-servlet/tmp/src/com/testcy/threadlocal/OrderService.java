package com.testcy.threadlocal;

public class OrderService {

    public void createOrder() {
        new OrderDao().saveOrder();
        String name = Thread.currentThread().getName();
//        System.out.println("OrderService当前线程：【" + name + "】执行完取出的数据为" + ThreadLocalTest.data.get(name));
        System.out.println("OrderService当前线程：【" + name + "】执行完取出的数据为" + ThreadLocalTest.data.get());
    }
}
