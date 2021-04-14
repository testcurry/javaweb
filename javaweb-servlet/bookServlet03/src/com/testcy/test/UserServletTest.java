package com.testcy.test;

import org.junit.Test;

import java.lang.reflect.Method;

public class UserServletTest {

    public void login() {
        System.out.println("Login业务测试。");

    }

    public void login(String name) {
        System.out.println("Login业务测试。");
        System.out.println(name);

    }

    public void regist() {
        System.out.println("Regist业务测试。");

    }

    public void updateUser() {
        System.out.println("updateUser业务测试。");

    }

    public void updateUserPassword() {
        System.out.println("updateUserPassword业务测试。");

    }

    @Test
    public void testReflect() {
        String action = "updateUser";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testInvove() {
        String action = "login";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action, String.class);
            System.out.println(method);
            method.invoke(new UserServletTest(),"Curry");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
