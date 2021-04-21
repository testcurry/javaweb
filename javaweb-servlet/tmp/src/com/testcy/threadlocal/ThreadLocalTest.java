package com.testcy.threadlocal;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {

//    public static ConcurrentHashMap data = new ConcurrentHashMap<String, Object>();
    public static ThreadLocal<Object> data=new ThreadLocal<>();
    public static Random random = new Random();

    public static class task implements Runnable {

        @Override
        public void run() {
            int i = random.nextInt(1000);//取0-999随机数
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("当前线程名【" + name + "】生成的随机数" + i);
//            data.set(name,i);
            data.set(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new OrderService().createOrder();


            //run方法结束之前，以当前线程名获取数据并打印，查看是否可以取出操作
//            Object o = data.get(name);
            Object o = data.get();
            System.out.println();
            System.out.println("在线程【" + name + "】快结束的时候取出关联的数据为：" + o);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new task()).start();
        }
    }

}
