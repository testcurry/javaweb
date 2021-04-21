package com.testcy.threadlocal;

public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
//        System.out.println("OrderDao当前线程：【" + name + "】执行完取出的数据为" + ThreadLocalTest.data.get(name));
        System.out.println("OrderDao当前线程：【" + name + "】执行完取出的数据为" + ThreadLocalTest.data.get());
    }
}
